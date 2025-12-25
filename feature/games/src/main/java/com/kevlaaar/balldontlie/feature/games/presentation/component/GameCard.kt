package com.kevlaaar.balldontlie.feature.games.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kevlaaar.baldontlie.domain.model.Game
import com.kevlaaar.baldontlie.domain.model.GameStatus

@Composable
fun GameCard (
    game: Game,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Card(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = game.status.toDisplayString(),
                style = MaterialTheme.typography.labelSmall,
                color = game.status.toColor(),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TeamScore(
                    teamName = game.homeTeam.abbreviation,
                    score = game.homeTeamScore,
                    isWinning = game.isHomeTeamWinning && game.status == GameStatus.FINAL,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "vs",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                TeamScore(
                    teamName = game.visitorTeam.abbreviation,
                    score = game.visitorTeamScore,
                    isWinning = game.isVisitorTeamWinning && game.status == GameStatus.FINAL,
                    modifier = Modifier.weight(1f),
                    alignEnd = true
                )
            }
        }
    }
}

@Composable
private fun TeamScore(
    teamName: String,
    score:Int,
    isWinning: Boolean,
    modifier: Modifier = Modifier,
    alignEnd: Boolean = false
){
    Column(
        modifier = modifier,
        horizontalAlignment = if (alignEnd) Alignment.End else Alignment.Start
    ) {
        Text(
            text = teamName,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = if (isWinning) FontWeight.Bold else FontWeight.Normal
        )
        Text(
            text = score.toString(),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = if (isWinning) FontWeight.Bold else FontWeight.Normal,
            color = if (isWinning) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface
            }
        )
    }
}

private fun GameStatus.toDisplayString(): String {
    return when (this) {
        GameStatus.FINAL -> "Final"
        GameStatus.IN_PROGRESS -> "Live"
        GameStatus.SCHEDULED -> "Scheduled"
        GameStatus.UNKNOWN -> "TBD"
    }
}

@Composable
private fun GameStatus.toColor() = when (this) {
    GameStatus.FINAL -> MaterialTheme.colorScheme.onSurfaceVariant
    GameStatus.IN_PROGRESS -> MaterialTheme.colorScheme.error
    GameStatus.SCHEDULED -> MaterialTheme.colorScheme.primary
    GameStatus.UNKNOWN -> MaterialTheme.colorScheme.onSurfaceVariant
}