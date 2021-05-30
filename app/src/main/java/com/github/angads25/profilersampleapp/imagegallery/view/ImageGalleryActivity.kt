package com.github.angads25.profilersampleapp.imagegallery.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.angads25.profilersampleapp.base.view.BaseActivity
import com.github.angads25.profilersampleapp.databinding.ActivityImageGridBinding
import com.github.angads25.profilersampleapp.imagegallery.intent.ImageGalleryIntent
import com.github.angads25.profilersampleapp.imagegallery.viewmodel.ImageGalleryViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ImageGalleryActivity: BaseActivity<ActivityImageGridBinding, ImageGalleryViewModel, ImageGalleryIntent.ViewEvent, ImageGalleryIntent.ViewEffect, ImageGalleryIntent.ViewState>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gridLayoutManager = GridLayoutManager(this, 3)
        binding.imageList.layoutManager = gridLayoutManager
        binding.imageList.adapter = ImageListAdapter()

        viewModel.processEvent(ImageGalleryIntent.ViewEvent.OnPageLoad("nature"))

        binding.imageList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    viewModel.processEvent(ImageGalleryIntent.ViewEvent.OnBottomOfList)
                }
            }
        })
    }

    override val bindingInflater: (LayoutInflater) -> ActivityImageGridBinding
        get() = ActivityImageGridBinding::inflate

    override fun renderState(state: ImageGalleryIntent.ViewState) {
        when(state) {
            is ImageGalleryIntent.ViewState.ShowLoader -> binding.loadingLayout.visibility =
                View.VISIBLE

            is ImageGalleryIntent.ViewState.HideLoader -> binding.loadingLayout.visibility =
                View.GONE

            is ImageGalleryIntent.ViewState.ShowError ->
                Snackbar.make(binding.root, "Error Loading Images", Snackbar.LENGTH_LONG).show()

            is ImageGalleryIntent.ViewState.Success -> {
                (binding.imageList.adapter as ImageListAdapter).addImages(state.data)
            }
        }
    }

    override fun renderEffect(effect: ImageGalleryIntent.ViewEffect) {
        when(effect) {
            is ImageGalleryIntent.ViewEffect.NavigateBack -> {

            }
        }
    }

    override fun viewModelType(): Class<ImageGalleryViewModel> = ImageGalleryViewModel::class.java
}