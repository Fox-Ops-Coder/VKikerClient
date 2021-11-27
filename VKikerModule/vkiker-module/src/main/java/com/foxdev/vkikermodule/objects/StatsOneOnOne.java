package com.foxdev.vkikermodule.objects;

import com.google.gson.annotations.SerializedName;

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
    public long AverageWinDuration;
    @SerializedName("averageLoseDuration")
    public long AverageLoseDuration;

    @SerializedName("averageGoalsConcededInWin")
    public double AverageGoalsConcededInWin;
    @SerializedName("averageGoalsScoredInDefeat")
    public double AverageGoalsScoredInDefeat;

    public int DefeatsCount;

    public double WinsPresent;

    public double AverageGoalsScorePerMatch;
    public double AverageGoalsConcededPerMatch;

    public void ComputeFields() {
        DefeatsCount = BattlesCount - WinsCount;

        if (BattlesCount >= 10) {
            WinsPresent = ((double)BattlesCount / (double)WinsCount) * 100.0;

            AverageGoalsScorePerMatch = (double)GoalsScoredCount / (double)BattlesCount;
            AverageGoalsConcededPerMatch = (double)GoalsConcededCount / (double)BattlesCount;
        }
    }
}
