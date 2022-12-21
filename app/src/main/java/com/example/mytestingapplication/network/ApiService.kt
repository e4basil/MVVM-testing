package com.example.mytestingapplication.network

import com.example.mytestingapplication.model.RepositoriesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(NetworkingConstants.URL_REPOSITORIES)
    suspend fun getPublicRepositories(
        @Query("since") since: String
    ): RepositoriesModel?
}