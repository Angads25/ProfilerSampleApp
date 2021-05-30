package com.github.angads25.profilersampleapp.mainscreen.intent

class MainActivityIntent {

sealed class MainActivityEvent {
    object ActionEvent: MainActivityEvent()
}

sealed class MainActivityEffect {
    object NavigateToGallery: MainActivityEffect()
}
}