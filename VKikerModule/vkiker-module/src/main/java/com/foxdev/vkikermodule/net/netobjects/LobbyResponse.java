package com.foxdev.vkikermodule.net.netobjects;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class LobbyResponse {
    @SerializedName("access")
    public boolean Access;

    @SerializedName("nameAttackA")
    @Nullable
    public String firstPlayerA;
    @SerializedName("nameAttackB")
    @Nullable
    public String secondPlayerA;

    @SerializedName("nameDefenceA")
    @Nullable
    public String firstPlayerB;
    @SerializedName("nameDefenceB")
    @Nullable
    public String secondPlayerB;

    @SerializedName("time")
    public long duration;
}
