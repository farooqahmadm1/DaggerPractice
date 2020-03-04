package com.example.daggerpractice1.di

import com.example.daggerpractice1.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module(includes = [ViewModelModule::class])
abstract class ActivityBuilderModule{
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeAuthActivity(): MainActivity
}