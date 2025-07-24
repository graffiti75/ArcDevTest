package com.cericatto.arcdev.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WelcomeResponse (
	val items: List<ArcItem>
)

@Serializable
data class ArcItem (
	val title: String = "",
	val media: Media = Media(),
	val description: String = "",
	val author: String = ""
)

@Serializable
data class Media (
	val m: String = ""
)
