package com.foxdev.vkikermodule.context;

import androidx.annotation.NonNull;

import com.foxdev.vkikermodule.net.VKikerServer;
import com.foxdev.vkikermodule.viewmodels.LeaderboardViewModel;
import com.foxdev.vkikermodule.viewmodels.UserViewModel;

import org.jetbrains.annotations.NotNull;

public final class ModuleContext {
    @NotNull
    private static final VKikerServer vKikerServer = new VKikerServer();
    @NonNull
    private static final UserViewModel userViewModel = new UserViewModel(vKikerServer);
    @NonNull
    private static final LeaderboardViewModel leaderboardViewModel = new LeaderboardViewModel(vKikerServer);
}
