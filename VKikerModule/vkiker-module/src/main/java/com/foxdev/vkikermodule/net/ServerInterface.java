package com.foxdev.vkikermodule.net;

import androidx.annotation.NonNull;

import com.foxdev.vkikermodule.objects.ShortUser;
import com.foxdev.vkikermodule.objects.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface ServerInterface {
    @GET("/leaderboard")
    @NonNull
    Call<List<ShortUser>> getLeaderBoard();

    @GET("/users?user=userId")
    @NonNull
    Call<User> getUser(@NonNull @Query("userId") String userId);
}