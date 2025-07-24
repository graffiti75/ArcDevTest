package com.cericatto.arcdev.ui.main_screen

import com.cericatto.arcdev.ui.navigation.Route

sealed interface MainScreenAction {
	data class GoToNextScreen(val route: Route) : MainScreenAction
}