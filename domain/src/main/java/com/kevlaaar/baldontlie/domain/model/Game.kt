package com.kevlaaar.baldontlie.domain.model

data class Game(
    val id: Int,
    val date: String,
    val season: Int,
    val status: GameStatus,
    val period: Int,
    val time: String?,
    val postseason: Boolean,
    val homeTeamScore: Int,
    val visitorTeamScore: Int,
    val homeTeam: Team,
    val visitorTeam: Team
) {
    val isHomeTeamWinning: Boolean get() = homeTeamScore > visitorTeamScore
    val isVisitorTeamWinning: Boolean get() = visitorTeamScore > homeTeamScore
    val isTied: Boolean get() = homeTeamScore == visitorTeamScore
}

enum class GameStatus {
    SCHEDULED,
    IN_PROGRESS,
    FINAL,
    UNKNOWN
}
