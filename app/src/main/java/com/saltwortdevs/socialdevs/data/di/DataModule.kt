package com.saltwortdevs.socialdevs.data.di

import com.saltwortdevs.socialdevs.data.datasource.api.ApiServices
import com.saltwortdevs.socialdevs.data.repository.AuthRepositoryImpl
import com.saltwortdevs.socialdevs.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideAuthRepository (api : ApiServices) : AuthRepository{ return AuthRepositoryImpl(api)}

    @Provides
    fun provideApiService (retrofit: Retrofit) : ApiServices{
        return retrofit.create(ApiServices::class.java)
    }

   @Provides
   fun provideRetroFit(json : Json) : Retrofit{
       return Retrofit
           .Builder()
           .baseUrl("https://socialdevs-d832c-default-rtdb.firebaseio.com/")
           .addConverterFactory(json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
           .build()
   }

    @Provides
    fun provideJson() : Json {
        return Json{
            ignoreUnknownKeys = true
            isLenient = true

        }
    }
}