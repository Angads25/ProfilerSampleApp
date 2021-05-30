package com.github.angads25.profilersampleapp.mainscreen.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.github.angads25.profilersampleapp.R
import com.github.angads25.profilersampleapp.base.view.BaseActivity
import com.github.angads25.profilersampleapp.databinding.ActivityMainBinding
import com.github.angads25.profilersampleapp.imagegallery.view.ImageGalleryActivity
import com.github.angads25.profilersampleapp.mainscreen.intent.MainActivityIntent
import com.github.angads25.profilersampleapp.mainscreen.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel, MainActivityIntent.ViewEvent, MainActivityIntent.ViewEffect, MainActivityIntent.ViewState>(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.actionButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.actionButton -> viewModel.processEvent(MainActivityIntent.ViewEvent.ActionEvent)
        }
    }

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun renderState(state: MainActivityIntent.ViewState) {

    }

    override fun renderEffect(effect: MainActivityIntent.ViewEffect) {
        when(effect) {
            is MainActivityIntent.ViewEffect.NavigateToGallery -> {
                startActivity(Intent(this, ImageGalleryActivity::class.java))
            }
        }
    }

    override fun viewModelType(): Class<MainActivityViewModel> = MainActivityViewModel::class.java
}