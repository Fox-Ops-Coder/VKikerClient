package com.foxdev.vkikermodule.net.netobjects;

import com.foxdev.vkikermodule.objects.User;
import com.google.gson.annotations.SerializedName;

public final class LeaderInfo {
    @SerializedName("user")
    public User user;

    @SerializedName("elo")
    public double ELO;

    @SerializedName("battles")
    public int Battles;

    @SerializedName("wins")
    public int Wins;
}
