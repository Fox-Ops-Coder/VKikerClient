package com.example.vkiker.connection

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.vkiker.MainActivity
import com.example.vkiker.R
import com.foxdev.vkikermodule.current.CurrentUser
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        if (remoteMessage.data.isNotEmpty()) {
            val data = remoteMessage.data;
            if (data.containsKey("duelWithId")) {
                val opponentId = data["duelWithId"];
                val message = data["duelWithName"] + " invited you to a duel";
                var broadcastIntent = Intent(application, MyBroadcastReciever::class.java).apply {
                    putExtra("opponentId", opponentId)
                };
                val broadcastPendingIntent: PendingIntent =
                    PendingIntent.getBroadcast(this, 0, broadcastIntent, 0)


                val builder = NotificationCompat.Builder(this, "com.vkikerchannel")
                    .setSmallIcon(R.drawable.ic_baseline_check_24)
                    .setContentTitle("This is duel!")
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setContentIntent(broadcastPendingIntent);

                with(NotificationManagerCompat.from(this)) {
                    notify(101, builder.build());
                }

            } else if (data.containsKey("goLobby")) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("OpenLobby", true);
                val peningIntent =
                    PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                val builder = NotificationCompat.Builder(this, "com.vkikerchannel")
                    .setSmallIcon(R.drawable.ic_baseline_check_24)
                    .setContentTitle("Game is ready")
                    .setContentText("Your opponent has accepted your challenge")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setContentIntent(peningIntent);
                BattleStates.BattleStates.postValue(BattleStates.WaitingBattleState);
                with(NotificationManagerCompat.from(this)) {
                    notify(102, builder.build());
                }
            } else if (data.containsKey("start")) {
                BattleStates.BattleStates.postValue(BattleStates.OnBattleState);
            }


        }

    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        val storageName = getString(R.string.loginStorageName)
        val mySharedPreferences = getSharedPreferences(storageName, Context.MODE_PRIVATE);
        val user = CurrentUser(mySharedPreferences);
        val userId = user.currentUser;


    }
}