package com.github.angads25.profilersampleapp.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.angads25.profilersampleapp.base.intent.BaseIntent

abstract class BaseViewModel<V: BaseIntent.ViewEvent, T: BaseIntent.ViewEffect, U: BaseIntent.ViewState>: ViewModel() {

    protected val effects: MutableLiveData<T> = MutableLiveData()

    protected val states: MutableLiveData<U> = MutableLiveData()

    fun getEffect(): MutableLiveData<T> = effects

    fun getState(): MutableLiveData<U> = states

    abstract fun processEvent(event: V)
}