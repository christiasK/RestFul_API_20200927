package com.example.restful_api_20200927.service

import com.example.restful_api_20200927.data.ResponseData
import retrofit2.Call
import retrofit2.http.*

interface JoinService {

    @GET("/email_check")
    fun emailCheck(@Query(value = "email") email: String): Call<ResponseData<Void>?>

    @PUT("/user")
    @FormUrlEncoded
    fun create(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("nick_name") nickName: String
    ): Call<ResponseData<Void>?>
}