package com.sdk.animekmm.android.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdk.animekmm.domain.use_case.GetAllCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCase: GetAllCharactersUseCase
): ViewModel() {
    private val _uiState: MutableStateFlow<MainState> = MutableStateFlow(MainState())
    val uiState: StateFlow<MainState> get() = _uiState
    init {
        getAllCharacters()
    }
    private fun getAllCharacters() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                val response = useCase(Unit)
                _uiState.value = _uiState.value.copy(isLoading = false, success = response)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message.toString(), isLoading = false)
            }
        }
    }
}