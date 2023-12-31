package ca.tetervak.paperrockorscissors.ui.result

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.tetervak.paperrockorscissors.R
import ca.tetervak.paperrockorscissors.domain.Choice
import ca.tetervak.paperrockorscissors.domain.GameResult

@Composable
fun ResultScreen(
    userChoice: Choice,
    computerChoice: Choice,
    gameResult: GameResult,
    onReplay: () -> Unit
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 24.sp,
            color = colorResource(id = R.color.pink_800)
        )
        Text(
            text = stringResource(R.string.game_result),
            fontSize = 20.sp,
            color = colorResource(id = R.color.green_800)
        )

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.computer),
                    fontSize = 18.sp,
                )
                Text(
                    text = choiceToString(choice = computerChoice),
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.purple_500)
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.you),
                    fontSize = 18.sp,
                )
                Text(
                    text = choiceToString(choice = userChoice),
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.purple_500)
                )
            }
        }

        Text(
            text = resultToString(gameResult = gameResult),
            fontSize = 20.sp,
            color = colorResource(id = R.color.orange_500)
        )

        Button(onClick = onReplay) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null
            )
            Text(
                text = stringResource(R.string.replay),
                fontSize = 20.sp
            )
        }
    }
}

@Composable
private fun choiceToString(choice: Choice): String =
    when (choice) {
        Choice.PAPER -> stringResource(id = R.string.paper)
        Choice.ROCK -> stringResource(id = R.string.rock)
        Choice.SCISSORS -> stringResource(id = R.string.scissors)
        else -> stringResource(R.string.unknown)
    }

@Composable
private fun resultToString(gameResult: GameResult): String =
    when (gameResult) {
        GameResult.USER_WINS -> stringResource(id = R.string.you_win)
        GameResult.COMPUTER_WINS -> stringResource(id = R.string.computer_wins)
        GameResult.REPLAY -> stringResource(id = R.string.play_again)
        else -> stringResource(R.string.unknown_result)
    }