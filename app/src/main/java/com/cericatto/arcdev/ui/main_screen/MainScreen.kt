package com.cericatto.arcdev.ui.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cericatto.arcdev.ui.common.FlickrListItem
import com.cericatto.arcdev.ui.utils.backgroundColor

@Composable
fun MainScreenRoot(
	modifier: Modifier = Modifier,
	viewModel: MainScreenViewModel = hiltViewModel()
) {
	val state by viewModel.state.collectAsStateWithLifecycle()
	MainScreen(
		modifier = modifier,
//		onAction = viewModel::onAction,
		state = state
	)
}

@Composable
private fun MainScreen(
	modifier: Modifier = Modifier,
//	onAction: (MainScreenAction) -> Unit,
	state: MainScreenState
) {
	if (state.arcItems.isNotEmpty()) {
		MainScreenContent(
			modifier = modifier,
//			onAction = onAction,
			state = state
		)
	}
}

@Composable
private fun MainScreenContent(
	modifier: Modifier = Modifier,
//	onAction: (MainScreenAction) -> Unit,
	state: MainScreenState
) {
	LazyColumn(
		modifier = modifier.fillMaxSize()
			.background(backgroundColor()),
		horizontalAlignment = Alignment.CenterHorizontally,
	) {
		itemsIndexed(state.arcItems) { index, item ->
			FlickrListItem(
				index = index,
				item = item,
				modifier = Modifier.wrapContentHeight()
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
	MainScreen(
//		onAction = {},
		state = MainScreenState()
	)
}