package com.cericatto.arcdev.ui.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
	@Serializable
	data object MainScreen: Route

	@Serializable
	data object DetailScreen: Route
}