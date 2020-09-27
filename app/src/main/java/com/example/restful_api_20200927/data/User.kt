package com.example.restful_api_20200927.data

import com.fasterxml.jackson.annotation.JsonProperty

class User(
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String
) {


    @JsonProperty("nick_name")
    lateinit var nickName: String

    @JsonProperty("created_at")
    lateinit var createdAt: String

    @JsonProperty("updated_at")
    lateinit var updatedAt: String
}