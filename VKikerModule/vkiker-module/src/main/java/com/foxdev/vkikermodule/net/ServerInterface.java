package com.foxdev.vkikermodule.net;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.foxdev.vkikermodule.net.netobjects.BattleResults;
import com.foxdev.vkikermodule.net.netobjects.DuelInvitation;
import com.foxdev.vkikermodule.net.netobjects.LeaderInfo;
import com.foxdev.vkikermodule.net.netobjects.LobbyResponse;
import com.foxdev.vkikermodule.net.netobjects.UserInfo;
import com.foxdev.vkikermodule.net.netobjects.UserAuthDTO;

import org.jetbrains.annotations.NotNull;

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

    @GET(Endpoints.LOG_IN)
    @NonNull
    Call<UserAuthDTO.ServerResponseData> Login(@NonNull @Path("userName") String userName);

    @POST(Endpoints.DUEL_INVITATION)
    @NonNull
    Call<DuelInvitation.InvitationResponse> InviteToDuel(@NonNull @Body DuelInvitation duelInvitations);

    @POST(Endpoints.DUEL_ACCEPT)
    @NonNull
    Call<DuelInvitation.InvitationResponse> AcceptDuel(@Nullable @Body DuelInvitation duelInvitation);

    @GET(Endpoints.LOBBY)
    @NonNull
    Call<LobbyResponse> GetLobby();

    @GET(Endpoints.BATTLE_READY)
    @NonNull
    Call<Void> ReadyForBattle(@NotNull @Path("userId") String userId);

    @GET(Endpoints.STOP_BATTLE)
    @NonNull
    Call<Void> StopBattle(@NonNull @Path("userId") String userId);

    @POST(Endpoints.SEND_BATTLE_RESULTS)
    @NonNull
    Call<Void> SendBattleResults(@NonNull @Body BattleResults battleResults);

    @POST(Endpoints.UPDATE_FCM)
    @NonNull
    Call<UserAuthDTO.ServerResponseData> UpdateFCM(@Body UserAuthDTO userAuthDTO);
}