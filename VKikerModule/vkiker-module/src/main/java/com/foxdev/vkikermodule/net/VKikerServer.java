package com.foxdev.vkikermodule.net;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.foxdev.vkikermodule.objects.Lobby;
import com.foxdev.vkikermodule.objects.ShortUser;
import com.foxdev.vkikermodule.objects.User;
import com.foxdev.vkikermodule.objects.UserAuthDTO;

import java.util.List;
import java.util.function.Consumer;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class VKikerServer {
    private final static String serverUrl = "http://10.0.6.190:4000";

    @NonNull
    private final ServerInterface serverInterface;
    @NonNull
    private final MutableLiveData<List<ShortUser>> shortUserLiveData;
    @NonNull
    private final MutableLiveData<Lobby> currentLobby;
    @NonNull
    private final MutableLiveData<User> userMutableLiveData;

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

        shortUserLiveData = new MutableLiveData<>(null);
        currentLobby = new MutableLiveData<>(null);
        userMutableLiveData = new MutableLiveData<>(null);
    }

    public void loadLeaderboards() {
        serverInterface.getLeaderBoard().enqueue(new Callback<List<ShortUser>>() {
            @Override
            public void onResponse(@NonNull Call<List<ShortUser>> call, @NonNull Response<List<ShortUser>> response) {
                if (response.isSuccessful()) {
                    shortUserLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ShortUser>> call, @NonNull Throwable t) {
                //TODO Do something with error
            }
        });
    }

    public void loadUserById(@NonNull String userId) {
        serverInterface.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.isSuccessful()) {
                    userMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                //TODO Do something with error
            }
        });
    }

    public void registerUser(@NonNull UserAuthDTO userAuthDTO,
                             @NonNull Consumer<UserAuthDTO.ServerResponseData> consumer) {
        serverInterface.Register(userAuthDTO).enqueue(new Callback<UserAuthDTO.ServerResponseData>() {
            @Override
            public void onResponse(@NonNull Call<UserAuthDTO.ServerResponseData> call,
                                   @NonNull Response<UserAuthDTO.ServerResponseData> response) {
                if (response.isSuccessful()) {
                    consumer.accept(response.body());
                } else {
                    consumer.accept(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserAuthDTO.ServerResponseData> call,
                                  @NonNull Throwable t) {
                consumer.accept(null);
            }
        });
    }

    @NonNull
    public LiveData<List<ShortUser>> getLeaders() {
        return shortUserLiveData;
    }
    @NonNull
    public LiveData<Lobby> getLobby() {
        return  currentLobby;
    }
    @NonNull
    public LiveData<User> getUserLiveData() {
        return userMutableLiveData;
    }
}
