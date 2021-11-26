package com.foxdev.vkikermodule.objects;

import androidx.annotation.NonNull;

public class ShortUser {
    @NonNull
    private String userId;
    @NonNull
    private String userName;

    private int elo;
    private int battleCount;
    private int winnPercentage;

    public ShortUser() {
        userId = "";
        userName = "";
    }

    @NonNull
    public final String getUserName() {
        return userName;
    }

    public final void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public final int getElo() {
        return elo;
    }

    public final void setElo(int elo) {
        this.elo = elo;
    }

    public final int getBattleCount() {
        return battleCount;
    }

    public final void setBattleCount(int battleCount) {
        this.battleCount = battleCount;
    }

    public final int getWinnPercentage() {
        return winnPercentage;
    }

    public final void setWinnPercentage(int winnPercentage) {
        this.winnPercentage = winnPercentage;
    }
}
