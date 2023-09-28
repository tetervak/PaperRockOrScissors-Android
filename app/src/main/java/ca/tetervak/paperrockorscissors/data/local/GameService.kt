package ca.tetervak.paperrockorscissors.data.local

import ca.tetervak.paperrockorscissors.domain.Choice
import ca.tetervak.paperrockorscissors.domain.GameResult

interface GameService {

    fun getGameResult(userChoice: Choice, computerChoice: Choice): GameResult

    fun getRandomChoice(): Choice
}