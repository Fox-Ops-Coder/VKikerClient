package com.example.vkiker.connection

import android.app.PendingIntent
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.vkiker.MainActivity
import com.example.vkiker.R
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
                val intent = Intent(this, MainActivity::class.java)

                val peningIntent =
                    PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                val builder = NotificationCompat.Builder(this, "fads")
                    .setSmallIcon(R.drawable.ic_baseline_check_24)
                    .setContentTitle("This is duel!")
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setContentIntent(peningIntent);

                with(NotificationManagerCompat.from(this)) {
                    notify(101, builder.build());
                }

            } else if (data.containsKey("goLobby")) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("OpenLobby", true);
                val peningIntent =
                    PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                val builder = NotificationCompat.Builder(this, "fads")
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

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
    }
}