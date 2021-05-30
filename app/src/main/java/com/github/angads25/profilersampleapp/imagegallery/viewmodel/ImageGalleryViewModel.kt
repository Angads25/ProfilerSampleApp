package com.github.angads25.profilersampleapp.imagegallery.viewmodel

import androidx.lifecycle.viewModelScope
import com.github.angads25.data.NetworkImageRepositoryImpl
import com.github.angads25.profilersampleapp.base.viewmodel.BaseViewModel
import com.github.angads25.profilersampleapp.imagegallery.intent.ImageGalleryIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageGalleryViewModel @Inject constructor(val networkImageRepositoryImpl: NetworkImageRepositoryImpl): BaseViewModel<ImageGalleryIntent.ViewEvent, ImageGalleryIntent.ViewEffect, ImageGalleryIntent.ViewState>() {

    var hasMorePages: Boolean = true
    var pageNumber = 1
    var query: String = ""


    fun loadImages() {
        viewModelScope.launch {
            states.value = ImageGalleryIntent.ViewState.ShowLoader
            kotlin.runCatching {
                networkImageRepositoryImpl.fetchImagesFromNetwork(query, pageNumber.toString())
            }.onSuccess {
                hasMorePages = it.next_page.isNotEmpty()
                if (hasMorePages) {
                    pageNumber++
                }

                states.value = ImageGalleryIntent.ViewState.HideLoader
                states.value = ImageGalleryIntent.ViewState.Success(it.photos)
            }.onFailure {
                states.value = ImageGalleryIntent.ViewState.HideLoader
                states.value = ImageGalleryIntent.ViewState.ShowError(it)
                it.printStackTrace()
            }
        }
    }

    override fun processEvent(event: ImageGalleryIntent.ViewEvent) {
        when(event) {
            is ImageGalleryIntent.ViewEvent.OnPageLoad -> {
                this.query = event.query
                loadImages()
            }
            is ImageGalleryIntent.ViewEvent.OnBottomOfList -> {
                if (hasMorePages) {
                    loadImages()
                }
            }
        }
    }
}