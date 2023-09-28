package ca.tetervak.paperrockorscissors.data.local

import ca.tetervak.paperrockorscissors.domain.Choice
import ca.tetervak.paperrockorscissors.domain.GameResult
import kotlin.random.Random

class GameServiceImpl(
    private val random: Random = Random.Default
): GameService {

    private val choices: List<Choice> =
        Choice.values().slice(0..2)

    override fun getRandomChoice(): Choice =
        choices.random(random)

    override fun getGameResult(
        userChoice: Choice,
        computerChoice: Choice
    ): GameResult =
        when (userChoice) {
            Choice.PAPER -> when (computerChoice) {
                Choice.PAPER -> GameResult.REPLAY
                Choice.ROCK -> GameResult.USER_WINS
                Choice.SCISSORS -> GameResult.COMPUTER_WINS
                else -> GameResult.UNKNOWN
            }
            Choice.ROCK -> when (computerChoice) {
                Choice.PAPER -> GameResult.COMPUTER_WINS
                Choice.ROCK -> GameResult.REPLAY
                Choice.SCISSORS -> GameResult.USER_WINS
                else -> GameResult.UNKNOWN
            }
            Choice.SCISSORS -> when (computerChoice) {
                Choice.PAPER -> GameResult.USER_WINS
                Choice.ROCK -> GameResult.COMPUTER_WINS
                Choice.SCISSORS -> GameResult.REPLAY
                else -> GameResult.UNKNOWN
            }
            else -> GameResult.UNKNOWN
        }
}