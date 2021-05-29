package com.github.angads25.profilersampleapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.angads25.profilersampleapp.R
import dagger.hilt.android.AndroidEntryPoint

class ImageGridActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_grid)
    }
}