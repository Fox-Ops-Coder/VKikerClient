package com.foxdev.vkikermodule.objects;

import androidx.annotation.Nullable;

public final class Lobby {
    @Nullable
    private String firstUser;

    @Nullable
    private String secondUser;

    @Nullable
    private String thirdUser;

    @Nullable
    private String fourUser;

    public Lobby() {
    }

    @Nullable
    public String getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(@Nullable String firstUser) {
        this.firstUser = firstUser;
    }

    @Nullable
    public String getFourUser() {
        return fourUser;
    }

    @Nullable
    public String getThirdUser() {
        return thirdUser;
    }

    @Nullable
    public String getSecondUser() {
        return secondUser;
    }

    public void setFourUser(@Nullable String fourUser) {
        this.fourUser = fourUser;
    }

    public void setSecondUser(@Nullable String secondUser) {
        this.secondUser = secondUser;
    }

    public void setThirdUser(@Nullable String thirdUser) {
        this.thirdUser = thirdUser;
    }
}
