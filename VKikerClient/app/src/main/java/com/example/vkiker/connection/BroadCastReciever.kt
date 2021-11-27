package com.example.vkiker.connection

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.vkiker.R
import com.foxdev.vkikermodule.context.ModuleContext
import com.foxdev.vkikermodule.current.CurrentUser
import com.foxdev.vkikermodule.net.netobjects.DuelInvitation

class MyBroadcastReciever : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val opponentId = intent.getStringExtra("opponentId");

        val storageName = context.getString(R.string.loginStorageName)
        val mySharedPreferences = context.getSharedPreferences(storageName, Context.MODE_PRIVATE);
        val user = CurrentUser(mySharedPreferences);
        val userId = user.currentUser;
        val invitation = DuelInvitation();
        invitation.opponentId = opponentId!!;
        invitation.senderId = userId!!;

        ModuleContext.vKikerServer.acceptDuel(invitation) {

        }
        val ns = Context.NOTIFICATION_SERVICE;
        val nMgr = context.getSystemService(ns) as NotificationManager;
        nMgr.cancel(101);
    }

}