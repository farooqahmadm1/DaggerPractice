package com.example.daggerpractice1.network.auth

import android.util.Log
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class AuthRepo @Inject constructor(authApi: AuthApi) {

    val authApi: AuthApi = authApi
    var firstTodo = liveData(Dispatchers.IO) {
        try {
            val result = authApi.getUser(1)
            emit(result)
        } catch (e: Throwable) {
            Log.e("Error", e.message)
        } catch (e: Exception) {
            Log.e("Error", e.message)
        }
    }
}