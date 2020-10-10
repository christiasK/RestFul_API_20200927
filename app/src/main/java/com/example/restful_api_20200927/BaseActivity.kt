package com.example.restful_api_20200927

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun setEvents()
    abstract fun setValues()

    fun setup() {
        setEvents()
        setValues()
    }

    fun getContext(): Context {
        return this
    }

}