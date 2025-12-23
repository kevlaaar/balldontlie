package com.kevlaaar.baldontlie.domain.repository

import com.kevlaaar.baldontlie.domain.model.Team

interface TeamsRepository {
    suspend fun getTeams(): Result<List<Team>>
}