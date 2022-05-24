package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getres(): Call<List<Post>>
}