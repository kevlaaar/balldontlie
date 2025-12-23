package com.kevlaaar.baldontlie.domain.repository

import com.kevlaaar.baldontlie.domain.model.Game

interface GamesRepository {
    suspend fun getGames(
        page: Int = 1,
        perPage: Int = 25,
        dates: List<String>? = null,
        teamIds: List<Int>? = null
    ): Result<List<Game>>
}