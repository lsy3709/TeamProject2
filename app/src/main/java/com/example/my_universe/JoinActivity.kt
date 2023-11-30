package com.example.my_universe

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.my_universe.MyApplication.Companion.rdb
import com.example.my_universe.databinding.ActivityJoinBinding
import com.example.my_universe.model.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class JoinActivity : AppCompatActivity() {
    lateinit var binding : ActivityJoinBinding
    lateinit var email : String
    lateinit var password : String
    lateinit var passwordCheck : String
    lateinit var name : String
    private lateinit var database: DatabaseReference
// ...

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)




        database = Firebase.database.reference

        binding.joinButton.setOnClickListener {
            // 리얼 타임 디비에 쓰기.
            // Create a new user with a first and last name
            email = binding.joinEmail.text.toString()
            password = binding.joinPassword.text.toString()
            passwordCheck = binding.joinPwck.text.toString()
            name = binding.joinName.text.toString()


            val user = User(
                name,email,password,passwordCheck
            )


//             Write a message to the database
//            val database = Firebase.database
//            val myRef = database.getReference("users")

            database.child("users").setValue(user)
//            myRef.setValue(user)
//            myRef.setValue("abc" , "def")

            // 기본쓰기 확인1
//            val database = Firebase.database
//            val myRef = database.getReference("message")
//
//            myRef.setValue("Hello, World!")

//            val user2 = User(name, email)

//            database.child("users").child("1").setValue(user)

            Log.d("scb", "name : ${name}")
            Log.d("scb", "password : ${password}")
            Log.d("scb", "passwordCheck : ${passwordCheck}")
            Log.d("scb", "email : ${email}")
        }



        // 리얼 타임 디비에 가져오기.


    }
}