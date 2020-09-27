package com.example.restful_api_20200927

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun setEvents()
    abstract fun setValues()

}