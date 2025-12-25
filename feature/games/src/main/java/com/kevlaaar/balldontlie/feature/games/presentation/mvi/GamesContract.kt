package com.kevlaaar.balldontlie.feature.games.presentation.mvi

import com.kevlaaar.baldontlie.domain.model.Game

data class GamesState(
    val isLoading: Boolean = false,
    val games: List<Game> = emptyList(),
    val error: String? = null,
    val selectedDate: String? = null
)

sealed interface GamesEvent {
    data object LoadGames: GamesEvent
    data object Refresh: GamesEvent
    data class OnDateSelected(val date: String): GamesEvent
    data class OnGameClick(val game: Game): GamesEvent
}

sealed interface GamesEffect {
    data class NavigateToGameDetail(val gameId: Int): GamesEffect
    data class ShowError(val message: String): GamesEffect
}

/**
 * Internal events that represent results of operations.
 * These are processed by the Reducer to update state.
 */
sealed interface GamesPartialState{
    data object Loading: GamesPartialState
    data class Success(val games: List<Game>): GamesPartialState
    data class Error(val message: String): GamesPartialState
    data class DateSelected(val date: String): GamesPartialState
}

