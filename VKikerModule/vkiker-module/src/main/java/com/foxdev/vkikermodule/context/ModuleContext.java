package com.foxdev.vkikermodule.context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.foxdev.vkikermodule.net.VKikerServer;
import com.foxdev.vkikermodule.viewmodels.LeaderboardViewModel;
import com.foxdev.vkikermodule.viewmodels.UserViewModel;

import org.jetbrains.annotations.NotNull;

public final class ModuleContext {
    @NotNull
    public static final VKikerServer vKikerServer = new VKikerServer();
    @NonNull
    public static final UserViewModel userViewModel = new UserViewModel(vKikerServer);
    @NonNull
    public static final LeaderboardViewModel leaderboardViewModel = new LeaderboardViewModel(vKikerServer);
    @Nullable
    public static String UserToken;
}
