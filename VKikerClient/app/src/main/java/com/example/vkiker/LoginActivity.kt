package com.example.vkiker

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.vkiker.databinding.ActivityLoginBinding
import com.example.vkiker.databinding.ActivityMainBinding
import android.content.SharedPreferences




class LoginActivity : AppCompatActivity() {
    private var _binding: ActivityLoginBinding? = null;
    private val binding get() = _binding!!;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        val storageName = "LoginStorage"
        val mySharedPreferences = getSharedPreferences(storageName, Context.MODE_PRIVATE);

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent);
    }
}