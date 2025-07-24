package com.cericatto.arcdev.data.di

import android.app.Application
import android.content.Context
import com.cericatto.arcdev.data.remote.ArcApi
import com.cericatto.arcdev.data.remote.ArcApi.Companion.BASE_URL
import com.cericatto.arcdev.data.repository.ArcRepositoryImpl
import com.cericatto.arcdev.domain.repository.ArcRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

	@Provides
	@Singleton
	fun provideContext(
		app: Application
	): Context {
		return app.applicationContext
	}

	@Provides
	@Singleton
	fun provideOkHttpClient(): OkHttpClient {
//		val loggingInterceptor = HttpLoggingInterceptor().apply {
//			HttpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//		}

		return OkHttpClient.Builder()
//			.addInterceptor(
//				HttpLoggingInterceptor().apply {
//					HttpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//				}
//			)
//			.addInterceptor(loggingInterceptor)
			.build()
	}

	@Provides
	@Singleton
	fun provideRepository(
		api: ArcApi
	): ArcRepository {
		return ArcRepositoryImpl(
			api = api
		)
	}

	@Provides
	@Singleton
	fun provideRickMortyApi(
		client: OkHttpClient,
		moshi: Moshi
	): ArcApi {
		return Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(MoshiConverterFactory.create(moshi))
			.client(client)
			.build()
			.create()
	}

	@Provides
	@Singleton
	fun provideMoshi(): Moshi {
		return Moshi.Builder()
			.add(KotlinJsonAdapterFactory())
			.build()
	}
}