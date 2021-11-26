package com.foxdev.vkikermodule.current;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class CurrentUser {

    private static final String USER_ID = "userId";

    @NonNull
    SharedPreferences sharedPreferences;

    public CurrentUser(@NonNull SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Nullable
    public String getCurrentUser() {
        return sharedPreferences.getString(USER_ID, null);
    }

    public void setCurrentUser(@NonNull String userId) {
        sharedPreferences.edit().putString(USER_ID, userId).apply();
    }
}
