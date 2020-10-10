package com.example.restful_api_20200927

import android.content.Intent
import android.os.Bundle

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
    }

    override fun setEvents() {

    }

    override fun setValues() {
        val intent = Intent(getContext(), LoginActivity::class.java)
        startActivityForResult(intent, 1000)
    }
}