package com.github.angads25.profilersampleapp.imagegallery.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.angads25.data.NetworkImageRepositoryImpl
import com.github.angads25.profilersampleapp.mainscreen.intent.MainActivityIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageGalleryViewModel @Inject constructor(val networkImageRepositoryImpl: NetworkImageRepositoryImpl): ViewModel() {

    private val effects: MutableLiveData<MainActivityIntent.ViewEffect> = MutableLiveData()

    fun init() {
        viewModelScope.launch {
            kotlin.runCatching {
                networkImageRepositoryImpl.fetchImagesFromNetwork("nature","1")
            }.onSuccess {

            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    fun getEffect(): MutableLiveData<MainActivityIntent.ViewEffect> = effects

}