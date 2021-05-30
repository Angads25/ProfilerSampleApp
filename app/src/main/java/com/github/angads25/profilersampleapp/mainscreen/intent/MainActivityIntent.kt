package com.github.angads25.profilersampleapp.mainscreen.intent

import com.github.angads25.profilersampleapp.base.intent.BaseIntent

interface MainActivityIntent: BaseIntent {
    sealed class ViewEvent: BaseIntent.ViewEvent {
        object ActionEvent: ViewEvent()
    }

    sealed class ViewEffect: BaseIntent.ViewEffect {
        object NavigateToGallery: ViewEffect()
    }

    sealed class ViewState: BaseIntent.ViewState
}