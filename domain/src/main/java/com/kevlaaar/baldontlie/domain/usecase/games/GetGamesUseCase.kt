package com.kevlaaar.baldontlie.domain.usecase.games

import com.kevlaaar.baldontlie.domain.model.Game
import com.kevlaaar.baldontlie.domain.repository.GamesRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val gamesRepository: GamesRepository
) {
    suspend operator fun invoke(
        page: Int = 1,
        perPage: Int = 25,
        dates: List<String>? = null,
        teamIds: List<Int>? = null
    ): Result<List<Game>> {
        return gamesRepository.getGames(
            page = page,
            perPage = perPage,
            dates = dates,
            teamIds = teamIds
        )
    }
}