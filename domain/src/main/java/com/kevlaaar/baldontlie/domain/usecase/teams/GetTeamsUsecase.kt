package com.kevlaaar.baldontlie.domain.usecase.teams

import com.kevlaaar.baldontlie.domain.model.Team
import com.kevlaaar.baldontlie.domain.repository.TeamsRepository
import javax.inject.Inject

class GetTeamsUsecase @Inject constructor(
    private val teamsRepository: TeamsRepository
) {
    suspend operator fun invoke(): Result<List<Team>> {
        return teamsRepository.getTeams()
    }
}