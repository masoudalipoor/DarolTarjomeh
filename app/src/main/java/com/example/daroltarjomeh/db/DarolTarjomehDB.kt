package com.example.daroltarjomeh.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.daroltarjomeh.db.dao.UserDAO
import com.example.daroltarjomeh.db.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class DarolTarjomehDB: RoomDatabase() {

    abstract fun userDao(): UserDAO

    companion object {
        @Volatile
        private var INSTANCE: DarolTarjomehDB? = null

        fun getDatabase(context: Context): DarolTarjomehDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DarolTarjomehDB::class.java,
                    "daroltarjomeh_database").build()

                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}