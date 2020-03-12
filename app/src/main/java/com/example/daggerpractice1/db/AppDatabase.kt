package com.example.daggerpractice1.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.daggerpractice1.model.UserResponse

@Database(
    entities = [UserResponse::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverterManager::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}