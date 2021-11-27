package com.foxdev.vkikermodule.net.netobjects;

import androidx.annotation.NonNull;

public final class BattleResults {
    @NonNull
    public String id;

    public boolean winner;

    public int goals;

    public BattleResults() {
        id = "";
    }
}
