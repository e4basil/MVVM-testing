package com.example.mytestingapplication.repository

import com.example.mytestingapplication.model.RepositoriesModel
import com.example.mytestingapplication.network.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getRepositoriesList(since: String): RepositoriesModel? {
        return apiService.getPublicRepositories(since = since)
    }
}