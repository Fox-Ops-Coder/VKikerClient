package com.foxdev.vkikermodule.net.netobjects;

import com.foxdev.vkikermodule.objects.StatsOneOnOne;
import com.foxdev.vkikermodule.objects.StatsTwoOnTwo;
import com.foxdev.vkikermodule.objects.User;
import com.google.gson.annotations.SerializedName;

public final class UserInfo {
    @SerializedName("user")
    public User user;

    @SerializedName("statsOneOnOne")
    public StatsOneOnOne statsOneOnOne;

    @SerializedName("statsTwoOnTwo")
    public StatsTwoOnTwo statsTwoOnTwo;
}
