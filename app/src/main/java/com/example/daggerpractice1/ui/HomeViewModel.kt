package com.example.daggerpractice1.ui

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(homeRepo: HomeRepo) : ViewModel() {
    private val repo = homeRepo
    val firstTodo = repo.firstTodo
}