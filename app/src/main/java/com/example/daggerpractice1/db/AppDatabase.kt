package com.example.daggerpractice1.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daggerpractice1.model.UserResponse

@Database(
    entities = [UserResponse::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}