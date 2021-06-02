package com.example.daroltarjomeh

import android.app.Application
import com.example.daroltarjomeh.db.DarolTarjomehDB
import com.example.daroltarjomeh.db.repository.UserRepository

class AppDaroltarjomeh: Application() {
    val database by lazy { DarolTarjomehDB.getDatabase(this) }
    val repository by lazy { UserRepository(database.userDao()) }
}