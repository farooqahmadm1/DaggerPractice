package com.example.daggerpractice1.network.auth

import retrofit2.http.GET
import retrofit2.http.Path
import com.example.daggerpractice1.model.UserResponse


interface AuthApi {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") id : Int) : UserResponse
}