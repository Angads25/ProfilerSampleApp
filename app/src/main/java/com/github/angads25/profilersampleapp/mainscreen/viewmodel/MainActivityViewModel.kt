package com.github.angads25.profilersampleapp.mainscreen.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.angads25.data.NetworkImageRepositoryImpl
import com.github.angads25.profilersampleapp.mainscreen.intent.MainActivityIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(val imageRepositoryImpl: NetworkImageRepositoryImpl): ViewModel() {

    private val effects: MutableLiveData<MainActivityIntent.MainActivityEffect> = MutableLiveData()

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

    fun getEffect(): MutableLiveData<MainActivityIntent.MainActivityEffect> = effects

    fun processEvent(event: MainActivityIntent.MainActivityEvent) {
        when (event) {
            is MainActivityIntent.MainActivityEvent.ActionEvent -> {
                effects.value = MainActivityIntent.MainActivityEffect.NavigateToGallery
            }
        }
    }
}