package com.example.restful_api_20200927

import android.os.Bundle
import android.util.Log
import com.example.restful_api_20200927.data.User
import com.example.restful_api_20200927.service.LoginService
import com.example.restful_api_20200927.utils.ServerUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setEvents()
        setValues()
    }

    override fun setEvents() {
        loginBtn.setOnClickListener {

            val service = ServerUtils.getService(LoginService::class.java)

            val inputId = idEdt.text.toString()
            val inputPw = pwEdt.text.toString()

            val user = User(inputId, inputPw)

            val response = service.login(user).execute()

            if (response.isSuccessful) {
                Log.d("결과 값", response.body().toString())
            } else {
                Log.d("오류 결과", response.errorBody().toString())
            }

        }
    }

    override fun setValues() {

    }
}