package com.example.restful_api_20200927.data

import com.google.gson.annotations.SerializedName

data class ProfileImage(
    var id: Int?,

    @SerializedName("user_id")
    var userId: Int?,

    @SerializedName("img_url")
    var imgUrl: String?,

    @SerializedName("created_at")
    var createdAt: String?,

    @SerializedName("updated_at")
    var updatedAt: String?
) {
}