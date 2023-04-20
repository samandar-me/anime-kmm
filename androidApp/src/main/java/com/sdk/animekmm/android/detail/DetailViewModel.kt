package com.sdk.animekmm.android.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdk.animekmm.domain.use_case.GetCharacterByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val useCase: GetCharacterByIdUseCase,
    id: Int
): ViewModel() {
    private val _uiState: MutableStateFlow<DetailState> = MutableStateFlow(DetailState())
    val uiState: StateFlow<DetailState> get() = _uiState

    init {
        getCharacterById(id)
    }
    private fun getCharacterById(id: Int) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                 _uiState.value = _uiState.value.copy(success = useCase(id))
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = e.message.toString())
            }
        }
    }
}