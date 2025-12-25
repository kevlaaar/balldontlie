package com.kevlaaar.balldontlie.data.repository

import com.kevlaaar.baldontlie.domain.model.Game
import com.kevlaaar.baldontlie.domain.repository.GamesRepository
import com.kevlaaar.balldontlie.data.mapper.toDomain
import com.kevlaaar.balldontlie.core.network.api.BallDontLieApi
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val api: BallDontLieApi
): GamesRepository {
    override suspend fun getGames(
        page: Int,
        perPage: Int,
        dates: List<String>?,
        teamIds: List<Int>?
    ): Result<List<Game>> {
        return try {
            val response = api.getGames(
                page = page,
                perPage = perPage,
                dates = dates,
                teamIds = teamIds
            )
            Result.success(response.data.map { it.toDomain() })
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}