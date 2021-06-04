package com.example.daroltarjomeh.main

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.daroltarjomeh.db.DarolTarjomehDB
import com.example.daroltarjomeh.db.dao.UserDAO
import com.example.daroltarjomeh.db.entity.UserEntity
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    lateinit var userDAO: UserDAO
    lateinit var db: DarolTarjomehDB
//
    @Before
    fun createDB() {
//        val context = ApplicationProvider.getApplicationContext<Context>()
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
    fun writeUserAndRead() = runBlocking {
        val register = UserEntity(123456, "m.alipoor73@yahoo.com")
        userDAO.insert(register)
        val login = userDAO.getUser()
        MatcherAssert.assertThat(login.toString(), true)
        assertEquals(login, register)
    }
}