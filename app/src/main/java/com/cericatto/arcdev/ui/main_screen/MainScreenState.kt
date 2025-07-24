package com.cericatto.arcdev.ui.main_screen

import com.cericatto.arcdev.data.model.ArcItem

data class MainScreenState(
//	val loading : Boolean = true,
	var arcItems : List<ArcItem> = emptyList(),
//	var isConnected : Boolean = true,
)