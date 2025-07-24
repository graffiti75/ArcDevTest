package com.cericatto.arcdev.ui.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cericatto.arcdev.domain.errors.Result
import com.cericatto.arcdev.domain.repository.ArcRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
	private val arcRepository: ArcRepository
): ViewModel() {

	private val _state = MutableStateFlow(MainScreenState())
	val state: StateFlow<MainScreenState> = _state.asStateFlow()

	/*
	fun onAction(action: MainScreenAction) {
		when (action) {
			is MainScreenAction.OnRetry -> fetchData()
			is MainScreenAction.LoadMore -> fetchMoreCharacters()
			is MainScreenAction.ClearError -> clearError()
		}
	}
	 */

	init {
		fetchData()
	}

	private fun fetchData() {
		viewModelScope.launch {
			when (val result = arcRepository.fetchData()) {
				is Result.Error -> {
					_state.update { state ->
						state.copy(
							arcItems = emptyList()
						)
					}
				}
				is Result.Success -> {
					_state.update { state ->
						state.copy(
							arcItems = result.data
						)
					}
				}
			}
		}
	}
}