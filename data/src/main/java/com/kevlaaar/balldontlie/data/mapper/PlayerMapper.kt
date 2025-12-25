package com.kevlaaar.balldontlie.data.mapper

import com.kevlaaar.baldontlie.domain.model.Player
import com.kevlaaar.balldontlie.core.network.model.PlayerDto

fun PlayerDto.toDomain(): Player {
    return Player(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        position = this.position,
        height = this.height,
        weight = this.weight,
        jerseyNumber = this.jerseyNumber,
        college = this.college,
        country = this.country,
        draftYear = this.draftYear,
        draftRound = this.draftRound,
        draftNumber = this.draftNumber,
        team = this.team?.toDomain(),
    )
}