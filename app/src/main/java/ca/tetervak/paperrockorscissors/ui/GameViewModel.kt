package ca.tetervak.paperrockorscissors.ui

import androidx.lifecycle.ViewModel
import ca.tetervak.paperrockorscissors.data.local.GameService
import ca.tetervak.paperrockorscissors.data.local.GameServiceImpl
import ca.tetervak.paperrockorscissors.domain.Choice
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<GameUiState> =
        MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState

    private val gameService: GameService = GameServiceImpl()

    fun onPlay() {
        if(uiState.value.userChoice != Choice.UNKNOWN){
            val computerChoice = gameService.getRandomChoice()
            _uiState.update { state ->
                state.copy(
                    computerChoice = computerChoice,
                    gameResult = gameService.getGameResult(
                        userChoice = state.userChoice,
                        computerChoice = computerChoice
                    ),
                    screen = Screen.RESULT
                )
            }
        }
    }

    fun onReplay() {
        _uiState.value = GameUiState()
    }

    fun onUserChoiceChange(newUserChoice: Choice) {
        _uiState.update { state ->
            state.copy(userChoice = newUserChoice)
        }
    }
}