package com.ajssoftwares.mvvmapplication

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class UserRepository {

    companion object{

        var userDatabase : UserDatabase? = null

        fun initializeDB(context: Context){
            userDatabase = UserDatabase.getDatabase(context)
        }

        fun insertData(context : Context, user : User){
            userDatabase = UserDatabase.getDatabase(context)
            CoroutineScope(IO).launch{
                userDatabase!!.userDao().insertUser(user)
            }
        }

        fun getData(context: Context) : LiveData<List<User>>{
            userDatabase = UserDatabase.getDatabase(context)
            return userDatabase!!.userDao().getAllUsers()
        }
    }
}