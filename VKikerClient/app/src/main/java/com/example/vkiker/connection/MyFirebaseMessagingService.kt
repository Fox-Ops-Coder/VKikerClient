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
            if (data.containsKey(BattleStates.DuelInvite)) {
                val message = data[BattleStates.DuelInviteMessage];
                val intent = Intent(this, MainActivity::class.java)

                val peningIntent =
                    PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);


                val builder = NotificationCompat.Builder(this, "fads")
                    .setSmallIcon(R.drawable.ic_baseline_check_24)
                    .setContentTitle("You was accepted to a duel!")
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setContentIntent(peningIntent);

                with(NotificationManagerCompat.from(this)) {
                    notify(101, builder.build());
                }

            }
            else if(data.containsKey(BattleStates.DuelAccepted)){
                BattleStates.BattleStates.postValue(BattleStates.WaitingBattleState);
            }


        }

    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
    }
}