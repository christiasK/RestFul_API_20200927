package com.example.restful_api_20200927.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    var email: String?,

    @SerializedName("password")
    var password: String?,

    @SerializedName("id")
    var id: Int? = 0,

    @SerializedName("nick_name")
    var nickName: String?,

    @SerializedName("created_at")
    var createdAt: String?,

    @SerializedName("updated_at")
    var updatedAt: String?,

    @SerializedName("profile_images")
    var profileImages: List<ProfileImage>?
) {
    constructor() :
            this(null, null, null, null, null, null, null)

    constructor(email: String, password: String, nickName: String) :
            this(email, password, null, nickName, null, null, null)
}