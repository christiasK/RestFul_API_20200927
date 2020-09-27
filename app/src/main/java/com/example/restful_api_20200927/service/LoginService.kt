package com.example.restful_api_20200927.service

import com.example.restful_api_20200927.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST




interface LoginService {

    @POST("/user")
    fun login(@Body user: User?): Call<User?>
}