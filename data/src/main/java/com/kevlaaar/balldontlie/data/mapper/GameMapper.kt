package com.kevlaaar.balldontlie.data.mapper

import com.kevlaaar.baldontlie.domain.model.Game
import com.kevlaaar.baldontlie.domain.model.GameStatus
import com.kevlaaar.balldontlie.core.network.model.GameDto

fun GameDto.toDomain(): Game {
    return Game(
        id = this.id,
        date = this.date,
        season = this.season,
        status = this.status.toGameStatus(),
        period = this.period,
        time = this.time,
        postseason = this.postseason,
        homeTeamScore = this.homeTeamScore,
        visitorTeamScore = this.visitorTeamScore,
        homeTeam = homeTeam.toDomain(),
        visitorTeam = visitorTeam.toDomain()
    )
}

private fun String.toGameStatus(): GameStatus{
    return when (this.lowercase()) {
        "final" -> GameStatus.FINAL
        "in progress", "in_progress" -> GameStatus.IN_PROGRESS
        "scheduled" -> GameStatus.SCHEDULED
        else -> GameStatus.UNKNOWN
    }
}