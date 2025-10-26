package com.example.retrofitpractice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun buildService(): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}