package com.example.daroltarjomeh.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daroltarjomeh.db.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(user: UserEntity)

    @Query("SELECT * FROM user_table")
    fun getUser(): Flow<UserEntity>
//            WHERE email=:email AND password=:password"

    @Query("SELECT * FROM user_table ORDER BY email ASC")
    suspend fun getSingleUser(): UserEntity
}