package com.kevlaaar.baldontlie.domain.usecase.players

import com.kevlaaar.baldontlie.domain.model.Player
import com.kevlaaar.baldontlie.domain.repository.PlayerRepository
import javax.inject.Inject

class GetPlayersUseCase @Inject constructor(
    private val playerRepository: PlayerRepository
) {
    suspend operator fun invoke(
        page: Int = 1,
        perPage: Int = 25,
        search: String? = null
    ): Result<List<Player>> {
        return playerRepository.getPlayers(
            page = page,
            perPage = perPage,
            search = search
        )
    }
}