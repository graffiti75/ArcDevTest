package com.cericatto.arcdev.data.remote

import com.cericatto.arcdev.data.model.WelcomeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ArcApi {

	companion object Companion {
		const val BASE_URL = "https://api.flickr.com/services/feeds/"

	}

	/**
	 * Gets all characters.
	 */
	@GET("photos_public.gne")
	suspend fun fetchData(
		@Query("tags") tags: String = "priime",
		@Query("format") format: String = "json",
		@Query("nojsoncallback") nojsoncallback: Int = 1,
	): WelcomeResponse
}