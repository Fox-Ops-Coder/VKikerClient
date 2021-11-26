package com.foxdev.vkikermodule.net;

import androidx.annotation.NonNull;

import com.foxdev.vkikermodule.objects.ShortUser;
import com.foxdev.vkikermodule.objects.User;
import com.foxdev.vkikermodule.objects.UserAuthDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServerInterface {
    @GET(Endpoints.LEADERBOARD_ENDPOINT)
    @NonNull
    Call<List<ShortUser>> getLeaderBoard();

    @GET(Endpoints.GET_USER)
    @NonNull
    Call<User> getUser(@NonNull @Query("userId") String userId);

    @POST(Endpoints.AUTH)
    @NonNull
    Call<UserAuthDTO.ServerResponseData> Register(@NonNull @Body UserAuthDTO userAuthDTO);
}