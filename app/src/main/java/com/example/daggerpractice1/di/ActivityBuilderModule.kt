package com.example.daggerpractice1.di

import com.example.daggerpractice1.di.auth.AuthModule
import com.example.daggerpractice1.di.auth.AuthViewModelModule
import com.example.daggerpractice1.ui.Auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule{

    @ContributesAndroidInjector(modules = [AuthViewModelModule::class,AuthModule::class])
    abstract fun contributeAuthActivity() : AuthActivity
}