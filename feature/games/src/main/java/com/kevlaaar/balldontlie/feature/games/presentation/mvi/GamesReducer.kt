package com.kevlaaar.balldontlie.feature.games.presentation.mvi

object GamesReducer {

    fun reduce(currentState: GamesState, partialState: GamesPartialState): GamesState {
        return when(partialState){
            is GamesPartialState.Loading -> {
                currentState.copy(
                    isLoading = true,
                    error = null
                )
            }

            is GamesPartialState.Success -> {
                currentState.copy(
                    isLoading = false,
                    games = partialState.games,
                    error = null
                )
            }

            is GamesPartialState.Error -> {
                currentState.copy(
                    isLoading = false,
                    error = partialState.message
                )
            }

            is GamesPartialState.DateSelected -> {
                currentState.copy(
                    selectedDate = partialState.date
                )
            }
        }
    }

}