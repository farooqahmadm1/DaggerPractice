package com.example.daggerpractice1.di

import android.app.Application
import androidx.room.Room
import com.example.daggerpractice1.db.AppDatabase
import com.example.daggerpractice1.db.UserDao
import com.example.daggerpractice1.network.RestApiServices
import com.example.daggerpractice1.util.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule{

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): RestApiServices = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        .create(RestApiServices::class.java)

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient
        .Builder()
        .connectTimeout(30, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.MINUTES)
        .writeTimeout(30, TimeUnit.MINUTES)
        .build()

    @Singleton
    @Provides
    fun provideRoomDatabase(app: Application): AppDatabase = Room
        .databaseBuilder(app, AppDatabase::class.java, "app_database")
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

}