package com.example.daggerpractice1.di

import com.example.daggerpractice1.util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule{

    @Provides
    fun someText():String{
        return "This is the Test"
    }

    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
               .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}