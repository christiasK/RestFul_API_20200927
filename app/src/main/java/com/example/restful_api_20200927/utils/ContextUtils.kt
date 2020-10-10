package com.example.restful_api_20200927.utils

import android.content.Context

class ContextUtils {

    companion object {
        private val PREF = "Daily10MinutePref"
        private val TOKEN_KEY = "LOGIN_TOKEN"


        fun updateToken(context: Context, token: String) {
            val pref = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            pref.edit().putString(TOKEN_KEY, token)
        }

        fun getToken(context: Context): String? {
            val pref = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            return pref.getString(TOKEN_KEY, "")
        }
    }
}