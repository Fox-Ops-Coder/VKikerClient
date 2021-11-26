package com.example.vkiker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.vkiker.databinding.ActivityMainBinding
import com.example.vkiker.databinding.LeaderboardFragmentBinding
import android.content.SharedPreferences
import com.google.firebase.messaging.FirebaseMessaging


class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null;
    private val binding get() = _binding!!;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
FirebaseMessaging.getInstance()
        val host =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment;

        binding.Me.setOnClickListener {
            host.findNavController().navigate(R.id.action_global_playerFragment);
        }

        binding.Leaders.setOnClickListener {
            host.findNavController().navigate(R.id.action_global_leaderboardFragment);
        }

    }
}