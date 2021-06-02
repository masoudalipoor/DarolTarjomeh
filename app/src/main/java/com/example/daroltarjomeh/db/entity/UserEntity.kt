package com.example.daroltarjomeh.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
    class UserEntity(
        @ColumnInfo(name = "password") val userPassword: Long,
        @PrimaryKey @ColumnInfo(name = "email") val userEmail: String
    ) {

//    @PrimaryKey(autoGenerate = true)
//    var id: Long ?= null

}