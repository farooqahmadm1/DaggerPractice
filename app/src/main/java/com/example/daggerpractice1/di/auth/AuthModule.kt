package com.example.daggerpractice1.di.auth

import com.example.daggerpractice1.network.auth.AuthApi
import com.example.daggerpractice1.network.auth.AuthRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object AuthModule {

    @JvmStatic
    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi{
        return retrofit.create(AuthApi::class.java)
    }

    @JvmStatic
    @Provides
    fun provideAuthRepo(authApi: AuthApi) = AuthRepo(authApi)

}