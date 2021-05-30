package com.github.angads25.profilersampleapp.imagegallery.intent

import com.github.angads25.domain.models.Photos
import com.github.angads25.profilersampleapp.base.intent.BaseIntent

interface ImageGalleryIntent: BaseIntent {
    sealed class ViewEvent: BaseIntent.ViewEvent {
        class OnPageLoad(val query: String): ViewEvent()
        object OnBottomOfList: ViewEvent()
    }

    sealed class ViewState: BaseIntent.ViewState {
        object ShowLoader: ViewState()
        object HideLoader: ViewState()
        class ShowError(throwable: Throwable): ViewState()
        class Success(val data: List<Photos>): ViewState()
    }

    sealed class ViewEffect: BaseIntent.ViewEffect {
        object NavigateBack: ViewEffect()
    }
}