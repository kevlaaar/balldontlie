package com.kevlaaar.balldontlie.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerDto(
    @SerialName("id") val id: Int,
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
    @SerialName("position") val position: String,
    @SerialName("height") val height: String? = null,
    @SerialName("weight") val weight: String? = null,
    @SerialName("jersey_number") val jerseyNumber: String? = null,
    @SerialName("college") val college: String? = null,
    @SerialName("country") val country: String? = null,
    @SerialName("draft_year") val draftYear: Int? = null,
    @SerialName("draft_round") val draftRound: Int? = null,
    @SerialName("draft_number") val draftNumber: Int? = null,
    @SerialName("team") val team: TeamDto? = null,
)

@Serializable
data class MetaDto(
    @SerialName("next_cursor") val nextCursor: Int? = null,
    @SerialName("per_page") val perPage: Int,
)

@Serializable
data class PlayersResponse(
    @SerialName("data") val data: List<PlayerDto>,
    @SerialName("meta") val meta: MetaDto,
)