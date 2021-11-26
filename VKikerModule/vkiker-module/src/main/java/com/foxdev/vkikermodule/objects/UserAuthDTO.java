package com.foxdev.vkikermodule.objects;

import com.google.gson.annotations.SerializedName;

public final class UserAuthDTO {
    @SerializedName("userName")
    public String userName;

    @SerializedName("fcmToken")
    public String fcmToken;

    public static final class ServerResponseData {
        @SerializedName("access")
        public boolean access;

        @SerializedName("test")
        public int value;

        @SerializedName("userId")
        public String userId;
    }
}
