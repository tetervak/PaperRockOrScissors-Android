package ca.tetervak.paperrockorscissors.ui

import androidx.lifecycle.ViewModel
import ca.tetervak.paperrockorscissors.domain.Choice
import ca.tetervak.paperrockorscissors.domain.GetGameResultUseCase
import ca.tetervak.paperrockorscissors.domain.GetRandomChoiceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getRandomChoiceUseCase: GetRandomChoiceUseCase,
    private val getGameResultUseCase: GetGameResultUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<GameUiState> =
        MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState

    fun onPlay() {
        if (uiState.value.userChoice != Choice.UNKNOWN) {
            val computerChoice = getRandomChoiceUseCase()
            _uiState.update { state ->
                state.copy(
                    computerChoice = computerChoice,
                    gameResult = getGameResultUseCase(
                        userChoice = state.userChoice,
                        computerChoice = computerChoice
                    )
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