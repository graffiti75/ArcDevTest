package com.cericatto.arcdev.domain.repository

import com.cericatto.arcdev.data.model.ArcItem
import com.cericatto.arcdev.domain.errors.DataError
import com.cericatto.arcdev.domain.errors.Result

interface ArcRepository {

	suspend fun fetchData(): Result<List<ArcItem>, DataError>
}