package com.example.retrofitpractice

import com.example.retrofitpractice.ServiceBuilder.buildService

class Repository {
    suspend fun getPosts(): List<PostResponse> {
        return buildService().getPosts()

    }
}