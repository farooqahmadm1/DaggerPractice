package com.example.daggerpractice1.network

import com.example.daggerpractice1.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface RestApiServices {
    @GET("posts/{id}")
    suspend fun getUser(@Path("id") id : Int) : UserResponse
}