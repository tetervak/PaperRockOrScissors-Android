package ca.tetervak.paperrockorscissors.ui

import ca.tetervak.paperrockorscissors.domain.Choice
import ca.tetervak.paperrockorscissors.domain.GameResult

data class GameUiState(
    val userChoice: Choice = Choice.UNKNOWN,
    val computerChoice: Choice = Choice.UNKNOWN,
    val gameResult: GameResult = GameResult.UNKNOWN
)
