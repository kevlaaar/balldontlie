package com.kevlaaar.balldontlie.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.kevlaaar.balldontlie.feature.games.navigation.GAMES_ROUTE
import com.kevlaaar.balldontlie.feature.games.navigation.gamesScreen


@Composable
fun BallDontLieNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = GAMES_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        gamesScreen { gameId ->
            // TODO: Navigate to game detail
        }
    }
}