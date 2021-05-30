package com.github.angads25.profilersampleapp.imagegallery.intent

import com.github.angads25.domain.models.PexelImageResponse
import com.github.angads25.profilersampleapp.base.intent.BaseIntent

interface ImageGalleryIntent: BaseIntent {
    sealed class ViewEvent: BaseIntent.ViewEvent {

    }

    sealed class ViewState: BaseIntent.ViewState {
        object Loading: ViewState()
        class Error(throwable: Throwable): ViewState()
        class Success(data: PexelImageResponse): ViewState()
    }

    sealed class ViewEffect: BaseIntent.ViewEffect {
        object NavigateBack: ViewEffect()
    }
}