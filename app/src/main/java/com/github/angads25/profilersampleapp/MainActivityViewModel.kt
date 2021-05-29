package com.github.angads25.profilersampleapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.angads25.data.NetworkImageRepositoryImpl
import com.github.angads25.domain.NetworkImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(val imageRepositoryImpl: NetworkImageRepositoryImpl): ViewModel() {

    fun init() {
        viewModelScope.launch {
            kotlin.runCatching {
                imageRepositoryImpl.fetchImagesFromNetwork("nature","1")
            }.onSuccess {

            }.onFailure {
                it.printStackTrace()
            }
        }
    }
}