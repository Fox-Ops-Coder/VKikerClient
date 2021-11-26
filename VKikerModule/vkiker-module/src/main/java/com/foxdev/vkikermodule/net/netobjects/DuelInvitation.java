package com.foxdev.vkikermodule.net.netobjects;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public final class DuelInvitation {
    @NonNull
    public String senderId;

    @NonNull
    public String receiverId;

    public DuelInvitation() {
        senderId = "";
        receiverId = "";
    }

    public class InvitationResponse {
        @SerializedName("access")
        public boolean Access;
    }
}
