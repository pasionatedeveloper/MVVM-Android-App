package com.ajssoftwares.mvvmapplication

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserViewModal : ViewModel() {

    var userDatabase = UserDatabase

    fun initializeDB(context: Context){
        UserRepository.initializeDB(context)
    }

    fun insertData(context : Context, user : User){

        CoroutineScope(IO).launch {
            UserRepository.insertData(context,user)
        }
    }

    fun getData(context : Context) : LiveData<List<User>>{
        return UserRepository.getData(context)
    }
}