package com.example.mytestingapplication.di

import com.example.mytestingapplication.network.ApiService
import com.example.mytestingapplication.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataRepositoryModule {

    @Provides
    fun provideDataRepository(apiService: ApiService): DataRepository {
        return DataRepository(apiService)
    }
}