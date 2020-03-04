package com.example.daggerpractice1.di

import com.example.daggerpractice1.HomeFragment
import com.example.daggerpractice1.di.auth.AuthModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector(modules = [AuthModule::class])
    abstract fun contributeHomeFragment(): HomeFragment
}