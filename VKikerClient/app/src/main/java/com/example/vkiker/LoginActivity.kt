package com.example.vkiker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.vkiker.databinding.ActivityLoginBinding
import com.example.vkiker.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private var _binding: ActivityLoginBinding? = null;
    private val binding get() = _binding!!;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
    }
}