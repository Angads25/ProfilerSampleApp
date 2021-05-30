package com.github.angads25.profilersampleapp.base.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.github.angads25.profilersampleapp.base.intent.BaseIntent
import com.github.angads25.profilersampleapp.base.viewmodel.BaseViewModel

abstract class BaseActivity<VB: ViewBinding, VM: BaseViewModel<U, VE, VS>, U: BaseIntent.ViewEvent, VE: BaseIntent.ViewEffect, VS: BaseIntent.ViewState>: AppCompatActivity() {

    protected lateinit var viewModel: VM

    protected lateinit var binding: VB

    abstract fun renderState(state: VS)

    abstract fun renderEffect(effect: VE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = bindingInflater.invoke(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(viewModelType())

        viewModel.getEffect().observe(this, {renderEffect(it)})
        viewModel.getState().observe(this, {renderState(it)})
    }

    abstract val bindingInflater: (LayoutInflater) -> VB

    abstract fun viewModelType(): Class<VM>
}