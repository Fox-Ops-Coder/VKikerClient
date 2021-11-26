package com.foxdev.vkikermodule.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.foxdev.vkikermodule.net.VKikerServer;
import com.foxdev.vkikermodule.objects.User;

import javax.inject.Inject;

public final class UserViewModel extends ViewModel {

    private final VKikerServer vKikerServer;

    @Inject
    public UserViewModel(@NonNull VKikerServer vKikerServer) {
        this.vKikerServer = vKikerServer;
    }

    @NonNull
    public LiveData<User> getUserLiveData() {
        return vKikerServer.getUserLiveData();
    }
}
