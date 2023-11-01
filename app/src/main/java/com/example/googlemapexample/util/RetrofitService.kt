package com.example.googlemapexample.util

import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitService {

    @POST("fcm/send")
    @Headers("Content-Type: application/json")
    fun sendMessage(
        @Header("Authorization") key : String,
        @Body message : FCMMessage
    ) : retrofit2.Call<ResponseBody>

}