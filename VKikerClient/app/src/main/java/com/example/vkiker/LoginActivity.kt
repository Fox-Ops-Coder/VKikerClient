package com.example.vkiker

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.vkiker.databinding.ActivityLoginBinding
import com.example.vkiker.databinding.ActivityMainBinding
import android.content.SharedPreferences
import android.util.Log
import com.foxdev.vkikermodule.current.CurrentUser
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging


class LoginActivity : AppCompatActivity() {
    private var _binding: ActivityLoginBinding? = null;
    private val binding get() = _binding!!;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        val storageName = "LoginStorage"
        val mySharedPreferences = getSharedPreferences(storageName, Context.MODE_PRIVATE);
        val user = CurrentUser(mySharedPreferences);
        val userId = user.currentUser;

        if (userId != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        } else {
            FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener {
                if (!it.isSuccessful) {
                    Log.w(ContentValues.TAG, "Fetching FCM registration token failed", it.exception)

                }
                val token = it.result
                Log.d(ContentValues.TAG, "Token= $token");

            })


        }


    }
}