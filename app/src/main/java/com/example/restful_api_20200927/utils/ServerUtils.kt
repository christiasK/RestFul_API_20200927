package com.example.restful_api_20200927.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerUtils {

    companion object {
        fun <T> getService(type: Class<T>): T {
            return Retrofit.Builder()
                .baseUrl("http://15.164.153.174")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(type)
        }
    }
}