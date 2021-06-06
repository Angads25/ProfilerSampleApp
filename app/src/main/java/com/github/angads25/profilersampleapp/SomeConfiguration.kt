package com.github.angads25.profilersampleapp

object SomeConfiguration{

    private var someFunction: Function<String> ?= null
    private var someFunctions: MutableList<Function<String>> = ArrayList()

    fun init(function: Function<String>) {
        someFunction = function
    }

    fun addFunction(function: Function<String>) {
        someFunctions.add(function)
    }

    fun clean() {
        someFunctions.clear()
        someFunction = null
    }
}