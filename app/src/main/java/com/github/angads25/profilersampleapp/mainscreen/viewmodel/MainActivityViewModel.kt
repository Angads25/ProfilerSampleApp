package com.github.angads25.profilersampleapp.mainscreen.viewmodel

import com.github.angads25.profilersampleapp.base.viewmodel.BaseViewModel
import com.github.angads25.profilersampleapp.mainscreen.intent.MainActivityIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(): BaseViewModel<MainActivityIntent.ViewEvent, MainActivityIntent.ViewEffect, MainActivityIntent.ViewState>() {

    override fun processEvent(event: MainActivityIntent.ViewEvent) {
        when (event) {
            is MainActivityIntent.ViewEvent.ActionEvent -> {
                effects.value = MainActivityIntent.ViewEffect.NavigateToGallery
            }
        }
    }
}