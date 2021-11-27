package com.example.vkiker.connection

import androidx.lifecycle.MutableLiveData

class BattleStates {
    companion object{
        val NoBattleState = "NoBattle";
        val WaitingOpponentState = "WaitingOpponent"
        val WaitingBattleState = "WaitingBattle"
        val OnBattleState = "OnBattle"

        var BattleStates = MutableLiveData<String>(NoBattleState)


    }

}