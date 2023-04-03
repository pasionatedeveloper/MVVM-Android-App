package com.ajssoftwares.mvvmapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajssoftwares.mvvmapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(){

    lateinit var binding : ActivityLoginBinding

    lateinit var user : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRegister.setOnClickListener {

            val name = binding.editTextName.text.toString()
            val email = binding.editTextEmail.text.toString()
            val phoneNumber = binding.editTextPhone.text.toString()

            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("name",name)
            intent.putExtra("email",email)
            intent.putExtra("phoneNumber",phoneNumber)
            startActivity(intent)
        }
    }
}