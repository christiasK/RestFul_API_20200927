package com.example.restful_api_20200927.data


data class ResponseData<T>(
    val code: Int?,
    val message: String,
    val data: T?
) {
    constructor(
        code: Int,
        message: String
    ) : this(code, message, null)

    constructor(
        message: String
    ) : this(null, message, null)
}