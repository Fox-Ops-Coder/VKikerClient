package com.foxdev.vkikermodule.viewmodels;

import android.widget.MultiAutoCompleteTextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.foxdev.vkikermodule.objects.Lobby;
import com.foxdev.vkikermodule.objects.ShortUser;

import java.util.List;

public final class LeaderboardViewModel extends ViewModel {
    private MutableLiveData<List<ShortUser>> shortUserLiveData;
    private MutableLiveData<Lobby> currentLobby;


    public LeaderboardViewModel() {
        shortUserLiveData = new MutableLiveData<>(null);
        currentLobby = new MutableLiveData<>(null);
    }

    public LiveData<List<ShortUser>> getLeaderBoardLiveData() {
        return shortUserLiveData;
    }

    public LiveData<Lobby> getCurrentLobbyLiveData() {
        return currentLobby;
    }

}
