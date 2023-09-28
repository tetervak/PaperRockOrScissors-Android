package ca.tetervak.paperrockorscissors.domain

import ca.tetervak.paperrockorscissors.data.local.GameService
import javax.inject.Inject

class GetGameResultUseCase @Inject constructor(
    private val gameService: GameService
) {
    operator fun invoke(
        userChoice: Choice,
        computerChoice: Choice
    ): GameResult = gameService.getGameResult(
        userChoice = userChoice,
        computerChoice = computerChoice
    )
}