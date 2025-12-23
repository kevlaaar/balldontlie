package com.kevlaaar.baldontlie.domain.usecase.players

import com.kevlaaar.baldontlie.domain.model.Player
import com.kevlaaar.baldontlie.domain.repository.PlayerRepository
import javax.inject.Inject

class SearchPlayersUseCase @Inject constructor(
    private val playerRepository: PlayerRepository
) {
    suspend operator fun invoke(query: String): Result<List<Player>> {
        if(query.length < 2) {
            return Result.success(emptyList())
        }
        return playerRepository.getPlayers(search = query)
    }
}