package com.example.restful_api_20200927

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.example.restful_api_20200927.data.User
import com.example.restful_api_20200927.service.LoginService
import com.example.restful_api_20200927.utils.ServerUtils
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.doAsync


class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setup()
    }

    override fun setEvents() {
        loginBtn.setOnClickListener {
            val service = ServerUtils.getService(LoginService::class.java)

            val inputId = idEdt.text.toString()
            val inputPw = pwEdt.text.toString()

            val user = User()

            val callBack = service.users()

            callBack.doAsync {

                val response = callBack.execute()
                Log.d("결과코드", response.body().toString())
            }
        }

        joinBtn.setOnClickListener {
            val intent = Intent(getContext(), JoinActivity::class.java)
            startActivityForResult(intent, 2100)
            finish()
        }
    }

    override fun setValues() {

    }

}
