package com.example.daggerpractice1.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.example.daggerpractice1.db.UserDao
import com.example.daggerpractice1.model.UserResponse
import com.example.daggerpractice1.network.RestApiServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepo @Inject constructor(
    private val apiServices: RestApiServices,
    private val userDao: UserDao
) {

    var user1 : LiveData<List<UserResponse>> = liveData(Dispatchers.IO) {
        try {
            val result = apiServices.getPostList()
            userDao.insert(result)
            emit(result)
        } catch (e: Exception) {
            Log.e("Error", e.message)
        }
    }

    var user = userDao.getUserList().asLiveData()
}