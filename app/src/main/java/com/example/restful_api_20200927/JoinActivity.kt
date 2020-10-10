package com.example.restful_api_20200927

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.restful_api_20200927.data.ResponseData
import com.example.restful_api_20200927.data.User
import com.example.restful_api_20200927.service.JoinService
import com.example.restful_api_20200927.utils.ServerUtils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_join.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class JoinActivity : BaseActivity() {
    private lateinit var service: JoinService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        setup()
    }

    override fun setEvents() {
        joinOverlapEmailBtn.setOnClickListener {
            val callBack = this.service.emailCheck(joinEmail.text.toString())

            callBack.doAsync {

                val response = callBack.execute()

                uiThread {
                    if (response.isSuccessful) {
                        Toast.makeText(getContext(), response.body()!!.message, Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        val gson = Gson()
                        val responseData = gson.fromJson<ResponseData<Void>>(
                            response.errorBody()?.string(),
                            ResponseData::class.java
                        )
                        Toast.makeText(getContext(), responseData.message, Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }

        joinBtn.setOnClickListener {

            val callBack = this.service.create(joinEmail.text.toString(),
                joinPassword.text.toString(),
                joinNickName.text.toString())

            callBack.doAsync {

                val response = callBack.execute()

                uiThread {
                    if (response.isSuccessful) {
                        Toast.makeText(getContext(), response.body()!!.message, Toast.LENGTH_SHORT)
                            .show()

                        val intent = Intent()
                        setResult(Activity.RESULT_OK, intent)
                        finish()
                    } else {
                        val contents = response.errorBody()!!.string()
                        Toast.makeText(getContext(), contents, Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    override fun setValues() {
        this.service = ServerUtils.getService(JoinService::class.java)
    }
}