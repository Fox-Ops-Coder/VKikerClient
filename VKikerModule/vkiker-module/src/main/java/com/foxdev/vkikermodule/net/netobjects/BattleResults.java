package com.foxdev.vkikermodule.net.netobjects;

import androidx.annotation.NonNull;

public final class BattleResults {
    @NonNull
    public String userId;

    public boolean isWinner;

    public int goalsCount;

    public BattleResults() {
        userId = "";
    }
}
