package com.kevlaaar.balldontlie.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameDto(
    @SerialName("id") val id: Int,
    @SerialName("date") val date: String,
    @SerialName("season") val season: Int,
    @SerialName("status") val status: String,
    @SerialName("period") val period: Int,
    @SerialName("time") val time: String? = null,
    @SerialName("postseason") val postseason: Boolean,
    @SerialName("home_team_score") val homeTeamScore: Int,
    @SerialName("visitor_team_score") val visitorTeamScore: Int,
    @SerialName("home_team") val homeTeam: TeamDto,
    @SerialName("visitor_team") val visitorTeam: TeamDto,
)

@Serializable
data class GamesResponse(
    @SerialName("data") val data: List<GameDto>,
    @SerialName("meta") val meta: MetaDto,
)