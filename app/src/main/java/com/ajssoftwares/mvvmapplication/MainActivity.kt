package com.ajssoftwares.mvvmapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajssoftwares.mvvmapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var adapter : RecyclerViewAdapter
    lateinit var binding : ActivityMainBinding
    var userList = ArrayList<User>()

    lateinit var viewModal: UserViewModal
    lateinit var user : User


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val name = intent.getStringExtra("name")!!
        val email = intent.getStringExtra("email")!!
        val phoneNumber = intent.getStringExtra("phoneNumber")!!

        viewModal = ViewModelProvider(this)[UserViewModal::class.java]
        insertData(name,email,phoneNumber)


        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(this,userList)



        viewModal.getData(this).observe(this@MainActivity) {
            binding.recyclerView.adapter = adapter
        }
    }


    private fun insertData(name : String, email : String, phoneNumber : String) {

        lifecycleScope.launch(IO) {
            user = User(name,email,phoneNumber)
            userList.add(user)
            viewModal.insertData(this@MainActivity,user)
        }
    }

    private fun getData() {

        lifecycleScope.launch(IO) {

        }

    }
}