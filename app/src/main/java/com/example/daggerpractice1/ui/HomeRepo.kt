package com.example.daggerpractice1.ui

import android.util.Log
import androidx.lifecycle.liveData
import com.example.daggerpractice1.network.RestApiServices
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class HomeRepo @Inject constructor(apiServices: RestApiServices) {

    var firstTodo = liveData(Dispatchers.IO) {
        try {
            val result = apiServices.getUser(1)
            emit(result)
        } catch (e: Throwable) {
            Log.e("Error", e.message)
        } catch (e: Exception) {
            Log.e("Error", e.message)
        }
    }
}