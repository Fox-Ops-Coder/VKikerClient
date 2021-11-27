package com.example.vkiker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
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
import androidx.core.app.NotificationCompat
import com.example.vkiker.connection.BattleStates
import com.foxdev.vkikermodule.current.CurrentUser
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
            val action = NavGraphDirections.actionGlobalPlayerFragment();
            val storageName = getString(R.string.loginStorageName)
            val mySharedPreferences = getSharedPreferences(storageName, Context.MODE_PRIVATE);
            val user = CurrentUser(mySharedPreferences);
            val userId = user.currentUser;
            action.userId = userId;
            host.findNavController().navigate(action);
        }

        var chanel = (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(
            NotificationChannel("com.vkikerchannel","VkikerChannel", NotificationManager.IMPORTANCE_DEFAULT)
        )

        val builder = NotificationCompat.Builder(this, "com.vkikerchannel")


        binding.Leaders.setOnClickListener {
            host.findNavController().navigate(R.id.action_global_leaderboardFragment);
        }

        val openLobby =intent.getBooleanExtra("OpenLobby", false);
        if(openLobby){
            host.findNavController().navigate(R.id.battleFragment);
            BattleStates.BattleStates.postValue(BattleStates.WaitingBattleState);



        }


    }
}