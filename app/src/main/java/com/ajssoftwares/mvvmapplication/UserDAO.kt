package com.ajssoftwares.mvvmapplication

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO {

    @Insert
    suspend fun insertUser(user : User)

    @Query("Select * from UsersTable")
    fun getAllUsers() : LiveData<List<User>>

    @Update
    suspend fun updateUser(user : User)

    @Delete
    suspend fun deleteUser(user: User)

}