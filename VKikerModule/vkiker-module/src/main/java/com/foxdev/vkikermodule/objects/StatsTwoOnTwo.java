package com.foxdev.vkikermodule.objects;

import com.google.gson.annotations.SerializedName;

public final class StatsTwoOnTwo {
    @SerializedName("elo")
    public double AkvELOn;

    @SerializedName("battlesInAttack")
    public int BattlesCountInAttack;
    @SerializedName("battlesInDefence")
    public int BattlesCountInDefence;

    @SerializedName("winsInAttack")
    public int WinsCountInAttack;
    @SerializedName("winsInDefence")
    public int WinsCountInDefence;

    @SerializedName("averageWinDuration")
    public long AverageWinDuration;
    @SerializedName("averageDefeatDuration")
    public long AverageLoseDuration;

    public int WinsCount;
    public int LoseCount;
    public int BattleCount;

    public double WinsPercentInAttack;
    public double WinsPercentInDefence;

    public void ComputeFields() {
        BattleCount = BattlesCountInAttack + BattlesCountInDefence;
        WinsCount = WinsCountInAttack + WinsCountInDefence;
        LoseCount = BattleCount - WinsCount;

        if (BattleCount >= 10) {
            WinsPercentInAttack = (double)BattlesCountInAttack / (double)WinsCountInAttack;
            WinsPercentInDefence = (double)BattlesCountInDefence / (double)WinsPercentInDefence;
        }
    }
}
