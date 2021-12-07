package com.foxdev.vkikermodule.objects;

import com.google.gson.annotations.SerializedName;

import java.text.DecimalFormat;

public final class StatsOneOnOne {
    @SerializedName("elo")
    public double AkvELOn;

    @SerializedName("wins")
    public int WinsCount;
    @SerializedName("battles")
    public int BattlesCount;

    @SerializedName("goalsScored")
    public int GoalsScoredCount;
    @SerializedName("goalsConceded")
    public int GoalsConcededCount;

    @SerializedName("averageWinDuration")
    public double AverageWinDuration;
    @SerializedName("averageLoseDuration")
    public double AverageLoseDuration;

    @SerializedName("averageGoalsConcededInWin")
    public double AverageGoalsConcededInWin;
    @SerializedName("averageGoalsScoredInDefeat")
    public double AverageGoalsScoredInDefeat;

    public int DefeatsCount;

    public double WinsPresent;
    public String WinsPresentString  = "expect 10 battles";
    public double AverageGoalsScorePerMatch;
    public double AverageGoalsConcededPerMatch;


    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void ComputeFields() {
        DefeatsCount = BattlesCount - WinsCount;

        if (BattlesCount >= 10) {
            WinsPresent = ((double)WinsCount / (double)BattlesCount) * 100.0;
            WinsPresentString = df.format(WinsPresent)+"%";

            AverageGoalsScorePerMatch = (double)GoalsScoredCount / (double)BattlesCount;
            AverageGoalsConcededPerMatch = (double)GoalsConcededCount / (double)BattlesCount;
        }
    }
}
