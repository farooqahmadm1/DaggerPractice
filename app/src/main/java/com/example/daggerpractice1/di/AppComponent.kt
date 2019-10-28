package com.example.daggerpractice1.di

import android.content.Context
import com.example.daggerpractice1.util.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        ViewModelFactoryModule::class
    ])
interface AppComponent : AndroidInjector<BaseApplication>{

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Context): AppComponent
    }
}