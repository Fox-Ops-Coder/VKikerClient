package com.foxdev.vkikermodule.objects;

public final class User extends ShortUser {
    private int defeatsCount;

    private int goalsCount;
    private float averageMissWhenWin;
    private float averageGoalWhenLose;

    private float averageWinMatchesDuration;
    private float averageLoseMatchesDuration;

    private int battlesCountTwoTwo;
    private int winsPropagateTwoOnTwo;
    private int eloTowOnTwo;

    private int twoOnTwoWins;
    private int twoOnTwoLoses;

    private int defenceWinCount;
    private int defenceWinPercentage;

    private int attackWinCount;
    private int attacksWinPercentage;

    public User() {
    }

    public final int getDefeatsCount() {
        return defeatsCount;
    }

    public final void setDefeatsCount(int defeatsCount) {
        this.defeatsCount = defeatsCount;
    }

    public final int getGoalsCount() {
        return goalsCount;
    }

    public final void setGoalsCount(int goalsCount) {
        this.goalsCount = goalsCount;
    }

    public final float getAverageMissWhenWin() {
        return averageMissWhenWin;
    }

    public final void setAverageMissWhenWin(float averageMissWhenWin) {
        this.averageMissWhenWin = averageMissWhenWin;
    }

    public final float getAverageGoalWhenLose() {
        return averageGoalWhenLose;
    }

    public final void setAverageGoalWhenLose(float averageGoalWhenLose) {
        this.averageGoalWhenLose = averageGoalWhenLose;
    }

    public final float getAverageWinMatchesDuration() {
        return averageWinMatchesDuration;
    }

    public final void setAverageWinMatchesDuration(float averageWinMatchesDuration) {
        this.averageWinMatchesDuration = averageWinMatchesDuration;
    }

    public final float getAverageLoseMatchesDuration() {
        return averageLoseMatchesDuration;
    }

    public final void setAverageLoseMatchesDuration(float averageLoseMatchesDuration) {
        this.averageLoseMatchesDuration = averageLoseMatchesDuration;
    }

    public final int getBattlesCountTwoTwo() {
        return battlesCountTwoTwo;
    }

    public final void setBattlesCountTwoTwo(int battlesCountTwoTwo) {
        this.battlesCountTwoTwo = battlesCountTwoTwo;
    }

    public final int getWinsPropagateTwoOnTwo() {
        return winsPropagateTwoOnTwo;
    }

    public final void setWinsPropagateTwoOnTwo(int winsPropagateTwoOnTwo) {
        this.winsPropagateTwoOnTwo = winsPropagateTwoOnTwo;
    }

    public final int getEloTowOnTwo() {
        return eloTowOnTwo;
    }

    public final void setEloTowOnTwo(int eloTowOnTwo) {
        this.eloTowOnTwo = eloTowOnTwo;
    }

    public final int getTwoOnTwoWins() {
        return twoOnTwoWins;
    }

    public final void setTwoOnTwoWins(int twoOnTwoWins) {
        this.twoOnTwoWins = twoOnTwoWins;
    }

    public final int getTwoOnTwoLoses() {
        return twoOnTwoLoses;
    }

    public final void setTwoOnTwoLoses(int twoOnTwoLoses) {
        this.twoOnTwoLoses = twoOnTwoLoses;
    }

    public final int getAttackWinCount() {
        return attackWinCount;
    }

    public final void setAttackWinCount(int attackWinCount) {
        this.attackWinCount = attackWinCount;
    }

    public final int getAttacksWinPercentage() {
        return attacksWinPercentage;
    }

    public final void setAttacksWinPercentage(int attacksWinPercentage) {
        this.attacksWinPercentage = attacksWinPercentage;
    }

    public final int getDefenceWinCount() {
        return defenceWinCount;
    }

    public final void setDefenceWinCount(int defenceWinCount) {
        this.defenceWinCount = defenceWinCount;
    }

    public final int getDefenceWinPercentage() {
        return defenceWinPercentage;
    }

    public final void setDefenceWinPercentage(int defenceWinPercentage) {
        this.defenceWinPercentage = defenceWinPercentage;
    }
}
