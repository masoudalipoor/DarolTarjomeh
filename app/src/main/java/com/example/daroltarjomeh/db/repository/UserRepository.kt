package com.example.daroltarjomeh.db.repository

import androidx.annotation.WorkerThread
import com.example.daroltarjomeh.db.dao.UserDAO
import com.example.daroltarjomeh.db.entity.UserEntity
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDAO: UserDAO) {

    val user: Flow<UserEntity> = userDAO.getUser()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(userEntity: UserEntity) {
        userDAO.insert(userEntity)
    }
}