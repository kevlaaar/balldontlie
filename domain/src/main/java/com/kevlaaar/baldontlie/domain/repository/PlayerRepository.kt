package com.kevlaaar.baldontlie.domain.repository

import com.kevlaaar.baldontlie.domain.model.Player

interface PlayerRepository {
    suspend fun getPlayers(
        page: Int = 1,
        perPage: Int = 25,
        search: String? = null
    ): Result<List<Player>>
}