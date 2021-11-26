package com.foxdev.vkikermodule.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.foxdev.vkikermodule.net.VKikerServer;
import com.foxdev.vkikermodule.objects.Lobby;
import com.foxdev.vkikermodule.objects.ShortUser;

import java.util.List;

public final class LeaderboardViewModel extends ViewModel {

    @NonNull
    private final VKikerServer vKikerServer;

    public LeaderboardViewModel(@NonNull VKikerServer vKikerServer) {
        this.vKikerServer = vKikerServer;
    }

    public void loadLeaderboard() {
        vKikerServer.loadLeaderboards();
    }

    public void loadUser(@NonNull String userId) {
        vKikerServer.loadUserById(userId);
    }

    @NonNull
    public LiveData<List<ShortUser>> getLeaders() {
        return vKikerServer.getLeaders();
    }

    @NonNull
    public LiveData<Lobby> getCurrentLobby() {
        return vKikerServer.getLobby();
    }
}
