package com.example.mytestingapplication.di

import com.example.mytestingapplication.repository.DataRepository
import com.example.mytestingapplication.usecase.DataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun providesDataUseCase(dataRepository: DataRepository): DataUseCase {
        return DataUseCase(dataRepository)
    }
}