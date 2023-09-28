package ca.tetervak.paperrockorscissors.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.tetervak.paperrockorscissors.ui.play.PlayScreen
import ca.tetervak.paperrockorscissors.ui.result.ResultScreen

@Composable
fun AppScreen() {

    val viewModel: GameViewModel = viewModel()
    val uiState: GameUiState by viewModel.uiState.collectAsState()

    when (uiState.screen) {
        Screen.PLAY -> PlayScreen(
            userChoice = uiState.userChoice,
            onUserChoiceChange = viewModel::onUserChoiceChange,
            onPlay = viewModel::onPlay
        )

        Screen.RESULT -> ResultScreen(
            userChoice = uiState.userChoice,
            computerChoice = uiState.computerChoice,
            gameResult = uiState.gameResult,
            onReplay = viewModel::onReplay
        )
    }
}

