package com.foxdev.vkikermodule.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.foxdev.vkikermodule.net.VKikerServer;
import com.foxdev.vkikermodule.objects.User;

public final class UserViewModel extends ViewModel {

    private final VKikerServer vKikerServer;

    public UserViewModel(VKikerServer vKikerServer) {
        this.vKikerServer = vKikerServer;
    }

    public LiveData<User> getUserLiveData() {
        return vKikerServer.getUserLiveData();
    }
}
