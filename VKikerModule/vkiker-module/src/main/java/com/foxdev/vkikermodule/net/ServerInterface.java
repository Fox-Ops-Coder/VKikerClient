package com.foxdev.vkikermodule.net;

import androidx.annotation.NonNull;

import com.foxdev.vkikermodule.net.netobjects.LeaderInfo;
import com.foxdev.vkikermodule.net.netobjects.UserInfo;
import com.foxdev.vkikermodule.net.netobjects.UserAuthDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ServerInterface {
    @GET(Endpoints.LEADERBOARD_ENDPOINT)
    @NonNull
    Call<List<LeaderInfo>> getLeaderBoard();

    @GET(Endpoints.GET_USER)
    @NonNull
    Call<UserInfo> getUser(@NonNull @Path("userId") String userId);

    @POST(Endpoints.AUTH)
    @NonNull
    Call<UserAuthDTO.ServerResponseData> Register(@NonNull @Body UserAuthDTO userAuthDTO);
}