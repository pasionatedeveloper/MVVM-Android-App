package com.ajssoftwares.mvvmapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UsersTable")
data class User(
    @ColumnInfo(name = "UserName")
    val userName : String,

    @ColumnInfo(name = "Email")
    val email : String,

    @ColumnInfo(name = "ContactNumber")
    val contactNumber : String)
{

    @PrimaryKey(autoGenerate = true)
    var id  = 0
}
