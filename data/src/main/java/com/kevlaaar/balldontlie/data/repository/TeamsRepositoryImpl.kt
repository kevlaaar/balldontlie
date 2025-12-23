package com.kevlaaar.balldontlie.data.repository

import com.kevlaaar.baldontlie.domain.model.Team
import com.kevlaaar.baldontlie.domain.repository.TeamsRepository
import com.kevlaaar.balldontlie.data.mapper.toDomain
import com.kevlaaar.balldontlie.network.api.BallDontLieApi
import javax.inject.Inject

class TeamsRepositoryImpl @Inject constructor(
    private val api: BallDontLieApi
): TeamsRepository {
    override suspend fun getTeams(): Result<List<Team>> {
        return try {
            val response = api.getTeams()
            Result.success(response.data.map { it.toDomain() })
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}