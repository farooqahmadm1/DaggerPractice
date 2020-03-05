package com.example.daggerpractice1.di

import androidx.lifecycle.ViewModel
import com.example.daggerpractice1.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindAuthViewModel(homeViewModel: HomeViewModel): ViewModel

}