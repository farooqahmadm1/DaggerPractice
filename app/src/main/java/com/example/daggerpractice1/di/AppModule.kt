package com.example.daggerpractice1.di

import com.example.daggerpractice1.util.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule{
    @Provides
    fun someText():String{
        return "This is the Test"
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
               .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val client: OkHttpClient.Builder = OkHttpClient.Builder()
        client.connectTimeout(30, TimeUnit.MINUTES)
        client.readTimeout(30, TimeUnit.MINUTES)
        client.writeTimeout(30, TimeUnit.MINUTES)
        return client.build()
    }
}