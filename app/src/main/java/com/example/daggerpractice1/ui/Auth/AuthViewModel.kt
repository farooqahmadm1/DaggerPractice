package com.example.daggerpractice1.ui.Auth

import androidx.lifecycle.ViewModel
import com.example.daggerpractice1.network.auth.AuthRepo
import javax.inject.Inject

class AuthViewModel @Inject constructor(authRepo: AuthRepo) : ViewModel() {
    private val repo = authRepo
    val firstTodo = repo.firstTodo
}