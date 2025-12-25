package com.kevlaaar.balldontlie.data.repository

import com.kevlaaar.baldontlie.domain.model.Player
import com.kevlaaar.baldontlie.domain.repository.PlayerRepository
import com.kevlaaar.balldontlie.data.mapper.toDomain
import com.kevlaaar.balldontlie.core.network.api.BallDontLieApi
import javax.inject.Inject

class PlayersRepositoryImpl @Inject constructor(
    private val api: BallDontLieApi
): PlayerRepository {
    override suspend fun getPlayers(
        page: Int,
        perPage: Int,
        search: String?
    ): Result<List<Player>> {
        return try {
            val response = api.getPlayers(
                page = page,
                perPage = perPage,
                search = search
            )
            Result.success(response.data.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}