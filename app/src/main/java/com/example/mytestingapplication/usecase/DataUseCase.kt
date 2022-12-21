package com.example.mytestingapplication.usecase

import com.example.mytestingapplication.model.RepositoriesModel
import com.example.mytestingapplication.network.ResultData
import com.example.mytestingapplication.repository.DataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataUseCase @Inject constructor(
    private val dataRepository: DataRepository
) {
    suspend fun getRepositoriesList(since: String): Flow<ResultData<RepositoriesModel>> {
        return flow {
            emit(ResultData.Loading)

            val repositoriesModel = dataRepository.getRepositoriesList(since = since)

            val resultData = if (repositoriesModel.isNullOrEmpty()) {
                ResultData.Failed()
            } else {
                ResultData.Success(repositoriesModel)
            }

            emit(resultData)
        }.catch {
            emit(ResultData.Failed())
        }
    }
}