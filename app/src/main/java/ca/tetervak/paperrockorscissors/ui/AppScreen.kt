package ca.tetervak.paperrockorscissors.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.tetervak.paperrockorscissors.ui.play.PlayScreen
import ca.tetervak.paperrockorscissors.ui.result.ResultScreen

@Composable
fun AppScreen() {

    val viewModel: GameViewModel = viewModel()
    val uiState: GameUiState by viewModel.uiState.collectAsState()

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "play"
    ) {
        composable(route = "play") {
            PlayScreen(
                userChoice = uiState.userChoice,
                onUserChoiceChange = viewModel::onUserChoiceChange,
                onPlay = {
                    viewModel.onPlay()
                    navController.navigate(route = "result")
                }
            )
        }
        composable(route = "result") {
            ResultScreen(
                userChoice = uiState.userChoice,
                computerChoice = uiState.computerChoice,
                gameResult = uiState.gameResult,
                onReplay = {
                    viewModel.onReplay()
                    navController.navigate(route = "play")
                }
            )
        }
    }
}

