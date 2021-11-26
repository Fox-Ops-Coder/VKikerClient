package com.foxdev.vkikermodule.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.foxdev.vkikermodule.net.VKikerServer;
import com.foxdev.vkikermodule.net.netobjects.LeaderInfo;
import com.foxdev.vkikermodule.objects.User;

import java.util.List;

public final class LeaderboardViewModel extends ViewModel {

    @NonNull
    private final VKikerServer vKikerServer;

    public LeaderboardViewModel(@NonNull VKikerServer vKikerServer) {
        this.vKikerServer = vKikerServer;
    }

    public void loadLeaders() {
        vKikerServer.loadLeaderBoards();
    }

    @NonNull
    public LiveData<List<LeaderInfo>> getLeaders() {
        return vKikerServer.getLeaders();
    }
}
