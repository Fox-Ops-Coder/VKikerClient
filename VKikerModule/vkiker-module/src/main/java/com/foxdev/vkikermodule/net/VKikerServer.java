package com.foxdev.vkikermodule.net;

import androidx.annotation.NonNull;

import com.foxdev.vkikermodule.objects.ShortUser;
import com.foxdev.vkikermodule.objects.User;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class VKikerServer {
    private final static String serverUrl = "http://10.0.6.190:4000/";

    @NonNull
    private final ServerInterface serverInterface;

    public VKikerServer() {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .build();

        serverInterface = new Retrofit.Builder()
                .baseUrl(serverUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ServerInterface.class);
    }

    public final void getLeaderBoard() {
        serverInterface.getLeaderBoard().enqueue(new Callback<List<ShortUser>>() {
            @Override
            public void onResponse(@NonNull Call<List<ShortUser>> call, @NonNull Response<List<ShortUser>> response) {

            }

            @Override
            public void onFailure(@NonNull Call<List<ShortUser>> call, @NonNull Throwable t) {

            }
        });
    }

    public final void getUser(final int userId) {
        serverInterface.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {

            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {

            }
        });
    }
}
