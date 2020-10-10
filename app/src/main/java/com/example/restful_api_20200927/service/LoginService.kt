package com.example.restful_api_20200927.service

import com.example.restful_api_20200927.data.ResponseData
import com.example.restful_api_20200927.data.User
import com.example.restful_api_20200927.data.Users
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface LoginService {

    @GET("/user")
    fun users(): Call<ResponseData<Users>?>

    @POST("/user")
    fun login(@Body user: User?): Call<User?>
}