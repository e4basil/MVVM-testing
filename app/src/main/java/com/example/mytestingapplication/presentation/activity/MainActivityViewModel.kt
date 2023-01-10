package com.example.mytestingapplication.presentation.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytestingapplication.model.RepositoriesModel
import com.example.mytestingapplication.network.ResultData
import com.example.mytestingapplication.usecase.DataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(private val dataUseCase: DataUseCase) :ViewModel() {

    val repositoryListLiveData: MutableLiveData<ResultData<RepositoriesModel?>> =
        MutableLiveData()

    fun getRepositoriesList(since: String) {
        viewModelScope.launch(Dispatchers.IO) {
            dataUseCase.getRepositoriesList(since = since).collect{
                repositoryListLiveData.postValue(it)
            }
        }
    }
}