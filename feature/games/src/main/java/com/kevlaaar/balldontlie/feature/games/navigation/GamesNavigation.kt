package com.kevlaaar.balldontlie.feature.games.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kevlaaar.balldontlie.feature.games.presentation.GamesScreen


const val GAMES_ROUTE = "games"

fun NavController.navigateToGames() {
    navigate(GAMES_ROUTE)
}

fun NavGraphBuilder.gamesScreen(
    onGameClick: (Int) -> Unit
) {
    composable(route = GAMES_ROUTE) {
        GamesScreen(onGameClick = onGameClick)
    }
}