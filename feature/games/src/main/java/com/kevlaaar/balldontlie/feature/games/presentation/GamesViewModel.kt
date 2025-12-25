package com.kevlaaar.balldontlie.feature.games.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kevlaaar.baldontlie.domain.model.Game
import com.kevlaaar.baldontlie.domain.usecase.games.GetGamesUseCase
import com.kevlaaar.balldontlie.feature.games.presentation.mvi.GamesEffect
import com.kevlaaar.balldontlie.feature.games.presentation.mvi.GamesEvent
import com.kevlaaar.balldontlie.feature.games.presentation.mvi.GamesPartialState
import com.kevlaaar.balldontlie.feature.games.presentation.mvi.GamesReducer
import com.kevlaaar.balldontlie.feature.games.presentation.mvi.GamesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val getGamesUseCase: GetGamesUseCase
): ViewModel() {

    private val _state = MutableStateFlow(GamesState())
    val state: StateFlow<GamesState> = _state.asStateFlow()

    private val _effects = Channel<GamesEffect>()
    val effects = _effects.receiveAsFlow()

    init {
        onEvent(GamesEvent.LoadGames)
    }

    fun onEvent(event: GamesEvent) {
        when(event) {
            is GamesEvent.LoadGames -> loadGames()
            is GamesEvent.Refresh -> loadGames()
            is GamesEvent.OnDateSelected -> onDateSelected(event.date)
            is GamesEvent.OnGameClick -> onGameClick(event.game)
        }
    }

    private fun reduceState(partialState: GamesPartialState) {
        val newState = GamesReducer.reduce(_state.value, partialState)
        _state.value = newState
    }

    private fun loadGames(){
        viewModelScope.launch {
            reduceState(GamesPartialState.Loading)

            val dates = _state.value.selectedDate?.let{
                listOf(it)
            }

            getGamesUseCase(dates = dates)
                .onSuccess { games ->
                    reduceState(GamesPartialState.Success(games))
                }
                .onFailure { exception ->
                    val errorMessage = exception.message ?: "Unknown error occurred"
                    reduceState(GamesPartialState.Error(errorMessage))
                    sendEffect(GamesEffect.ShowError(errorMessage))
                }
        }
    }

    private fun onDateSelected(date: String) {
        reduceState(GamesPartialState.DateSelected(date))
        loadGames()
    }

    private fun onGameClick(game: Game) {
        sendEffect(GamesEffect.NavigateToGameDetail(game.id))
    }

    private fun sendEffect(effect: GamesEffect) {
        viewModelScope.launch {
            _effects.send(effect)
        }
    }
}