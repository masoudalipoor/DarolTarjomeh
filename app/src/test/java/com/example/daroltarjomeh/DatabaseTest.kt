package com.example.daroltarjomeh

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.daroltarjomeh.db.DarolTarjomehDB
import com.example.daroltarjomeh.db.dao.UserDAO
import com.example.daroltarjomeh.db.entity.UserEntity
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

class DatabaseTest {

    lateinit var userDAO: UserDAO
    lateinit var db: DarolTarjomehDB

    @Before
    fun createDB() {
        val context = InstrumentationRegistry.getInstrumentation().context
        db = Room.inMemoryDatabaseBuilder(context, DarolTarjomehDB::class.java).build()
        userDAO = db.userDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDB() {
        db.close()
    }

    @Test
    suspend fun writeUserAndRead() {
        val userEntity = UserEntity(123456, "m.alipoor73@yahoo.com")
        userDAO.insert(userEntity)
    }
}