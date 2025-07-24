package com.cericatto.arcdev.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cericatto.arcdev.ui.main_screen.MainScreenRoot

@Composable
fun NavHostComposable(
	modifier: Modifier = Modifier
) {
	val navController = rememberNavController()
	NavHost(
		navController = navController,
		startDestination = Route.MainScreen
	) {
		composable<Route.MainScreen> {
			MainScreenRoot(
				modifier = modifier
			)
		}
//		composable<Route.DetailScreen> {
//			DetailScreenRoot(
//				modifier = modifier
//			)
//		}
	}
}