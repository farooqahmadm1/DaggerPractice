package com.example.daggerpractice1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repo: HomeRepo
) : ViewModel() {
    val createCall = repo.user1
    val user = repo.user
}