package com.foxdev.vkikermodule.net;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.foxdev.vkikermodule.net.netobjects.LeaderInfo;
import com.foxdev.vkikermodule.net.netobjects.UserInfo;
import com.foxdev.vkikermodule.objects.User;
import com.foxdev.vkikermodule.net.netobjects.UserAuthDTO;

import java.util.Comparator;
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
    private final MutableLiveData<List<LeaderInfo>> leaderLiveData;
    @NonNull
    private final MutableLiveData<UserInfo> userLiveData;

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

        leaderLiveData = new MutableLiveData<>(null);
        userLiveData = new MutableLiveData<>(null);
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

    public void getUser(@NonNull String userId) {
        serverInterface.getUser(userId).enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(@NonNull Call<UserInfo> call,
                                   @NonNull Response<UserInfo> response) {
                if (response.isSuccessful()) {
                    UserInfo userInfo = response.body();

                    if (userInfo != null) {
                        userInfo.statsOneOnOne.ComputeFields();
                        userInfo.statsTwoOnTwo.ComputeFields();

                        userLiveData.postValue(userInfo);
                    } else {
                        userLiveData.postValue(null);
                    }
                } else {
                    userLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserInfo> call,
                                  @NonNull Throwable t) {
                userLiveData.postValue(null);
            }
        });
    }

    public void loadLeaderBoards() {
        serverInterface.getLeaderBoard().enqueue(new Callback<List<LeaderInfo>>() {
            @Override
            public void onResponse(@NonNull Call<List<LeaderInfo>> call,
                                   @NonNull Response<List<LeaderInfo>> response) {
                if (response.isSuccessful()) {
                    List<LeaderInfo> leaderInfos = response.body();

                    if (leaderInfos != null) {
                        leaderInfos.sort(Comparator.comparingDouble(o -> o.ELO));

                        for (int index = 0; index < leaderInfos.size(); ++index) {
                            leaderInfos.get(index).Number = "#" + index;
                            leaderInfos.get(index).IntNumber = index;
                        }

                        leaderLiveData.postValue(leaderInfos);
                    } else {
                        leaderLiveData.postValue(null);
                    }
                } else {
                    leaderLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<LeaderInfo>> call,
                                  @NonNull Throwable t) {
                leaderLiveData.postValue(null);
            }
        });
    }

    @NonNull
    public LiveData<List<LeaderInfo>> getLeaders() {
        return leaderLiveData;
    }

    @NonNull
    public LiveData<UserInfo> getUserLiveData() {
        return userLiveData;
    }
}
