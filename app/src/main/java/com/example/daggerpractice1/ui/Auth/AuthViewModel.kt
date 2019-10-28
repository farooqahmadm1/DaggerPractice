package com.example.daggerpractice1.ui.Auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

import com.example.daggerpractice1.network.auth.AuthApi
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class AuthViewModel @Inject constructor(authApi: AuthApi):ViewModel(){

    val authApi: AuthApi = authApi
    val firstTodo = liveData(Dispatchers.IO) {
        emit(authApi.getUser(1))
    }
}
