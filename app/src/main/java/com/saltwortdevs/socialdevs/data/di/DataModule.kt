package com.saltwortdevs.socialdevs.data.di

import com.saltwortdevs.socialdevs.data.repository.AuthRepositoryImpl
import com.saltwortdevs.socialdevs.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideAuthRepository () : AuthRepository{ return AuthRepositoryImpl()}
}