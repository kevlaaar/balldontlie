package com.kevlaaar.balldontlie.data.mapper

import com.kevlaaar.baldontlie.domain.model.Team
import com.kevlaaar.balldontlie.network.model.TeamDto

fun TeamDto.toDomain(): Team {
    return Team(
        id = this.id,
        conference = this.conference,
        division = this.division,
        city = this.city,
        name = this.name,
        fullName = this.fullName,
        abbreviation = this.abbreviation
    )
}