package com.example.daggerpractice1.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daggerpractice1.model.UserResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userResponse: UserResponse)

    @Query("SELECT * FROM USER")
    fun getUser(): Flow<UserResponse>
}