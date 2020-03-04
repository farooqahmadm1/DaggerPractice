package com.example.daggerpractice1.di

import androidx.lifecycle.ViewModel
import com.example.daggerpractice1.ui.Auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel) :ViewModel

}