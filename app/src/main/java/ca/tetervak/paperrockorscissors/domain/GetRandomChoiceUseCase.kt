package ca.tetervak.paperrockorscissors.domain

import ca.tetervak.paperrockorscissors.data.local.GameService
import javax.inject.Inject

class GetRandomChoiceUseCase @Inject constructor(
    private val gameService: GameService
) {
    operator fun invoke() = gameService.getRandomChoice()
}