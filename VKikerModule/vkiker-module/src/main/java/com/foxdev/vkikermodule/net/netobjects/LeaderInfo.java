package com.foxdev.vkikermodule.net.netobjects;

import androidx.annotation.NonNull;

import com.foxdev.vkikermodule.objects.User;
import com.google.gson.annotations.SerializedName;

public final class LeaderInfo {
    @SerializedName("user")
    public User user;

    @SerializedName("elo")
    public float ELO;

    @SerializedName("battles")
    public int Battles;

    @SerializedName("wins")
    public int Wins;

    @NonNull
    public String Number;

    public int IntNumber;

    public LeaderInfo() {
        Number = "";
    }
}
