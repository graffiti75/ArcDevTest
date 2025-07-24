package com.cericatto.arcdev.data.repository

import com.cericatto.arcdev.data.model.ArcItem
import com.cericatto.arcdev.data.remote.ArcApi
import com.cericatto.arcdev.domain.errors.DataError
import com.cericatto.arcdev.domain.errors.Result
import com.cericatto.arcdev.domain.errors.checkHttpException
import com.cericatto.arcdev.domain.repository.ArcRepository
import retrofit2.HttpException
import java.io.IOException

class ArcRepositoryImpl(
	private val api: ArcApi,
) : ArcRepository {

	override suspend fun fetchData(): Result<List<ArcItem>, DataError> {
		return try {
			val response = api.fetchData()
			if (response.items.isNotEmpty()) {
				Result.Success(data = response.items)
			} else {
				Result.Success(data = emptyList())
			}
		} catch (e: HttpException) {
			checkHttpException(e.code())
		} catch (e: IOException) {
			Result.Error(DataError.Network.NO_INTERNET)
		}
	}
}