package com.foxdev.vkikermodule.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.foxdev.vkikermodule.objects.User;

public final class UserViewModel extends ViewModel {
    private MutableLiveData<User> userMutableLiveData;

    public UserViewModel() {
        userMutableLiveData = new MutableLiveData<>(null);
    }

    public LiveData<User> getUserLiveData() {
        return userMutableLiveData;
    }
}
