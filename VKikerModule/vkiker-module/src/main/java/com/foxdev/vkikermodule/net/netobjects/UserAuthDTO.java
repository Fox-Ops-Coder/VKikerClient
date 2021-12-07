package com.foxdev.vkikermodule.net.netobjects;

import com.google.gson.annotations.SerializedName;

public final class UserAuthDTO {
    @SerializedName("userName")
    public String userName;

    @SerializedName("fcmToken")
    public String fcmToken;

    public static final class ServerResponseData {
        @SerializedName("access")
        public boolean access;

        @SerializedName("message")
        public String message;

        @SerializedName("id")
        public String userId;
    }
}
