package com.github.angads25.profilersampleapp.mainscreen.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.github.angads25.profilersampleapp.R
import com.github.angads25.profilersampleapp.databinding.ActivityMainBinding
import com.github.angads25.profilersampleapp.mainscreen.intent.MainActivityIntent
import com.github.angads25.profilersampleapp.mainscreen.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.init()
        mainActivityViewModel.getEffect().observe(this, {
            when(it) {
                is MainActivityIntent.MainActivityEffect.NavigateToGallery -> {
                    startActivity(Intent(this, ImageGridActivity::class.java))
                }
            }
        })

        binding.actionButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.actionButton -> mainActivityViewModel.processEvent(MainActivityIntent.MainActivityEvent.ActionEvent)
        }
    }
}