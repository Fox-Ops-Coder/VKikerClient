package com.foxdev.vkikermodule.net;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.foxdev.vkikermodule.net.netobjects.DuelInvitation;
import com.foxdev.vkikermodule.net.netobjects.LeaderInfo;
import com.foxdev.vkikermodule.net.netobjects.UserAuthDTO;
import com.foxdev.vkikermodule.net.netobjects.UserInfo;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(interceptor)
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

    public void inviteToDuel(@NonNull DuelInvitation duelInvitations,
                             @NonNull Consumer<DuelInvitation.InvitationResponse> consumer) {
        serverInterface.InviteToDuel(duelInvitations).enqueue(new Callback<DuelInvitation.InvitationResponse>() {
            @Override
            public void onResponse(@NonNull Call<DuelInvitation.InvitationResponse> call,
                                   @NonNull Response<DuelInvitation.InvitationResponse> response) {
                if (response.isSuccessful()) {
                    consumer.accept(response.body());
                } else {
                    consumer.accept(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<DuelInvitation.InvitationResponse> call,
                                  @NonNull Throwable t) {
                consumer.accept(null);
            }
        });
    }

    public void acceptDuel(@NonNull DuelInvitation duelInvitation,
                           @NonNull Consumer<DuelInvitation.InvitationResponse> consumer) {
        serverInterface.AcceptDuel(duelInvitation).enqueue(new Callback<DuelInvitation.InvitationResponse>() {
            @Override
            public void onResponse(@NonNull Call<DuelInvitation.InvitationResponse> call,
                                   @NonNull Response<DuelInvitation.InvitationResponse> response) {
                if (response.isSuccessful()) {
                    consumer.accept(response.body());
                } else {
                    consumer.accept(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<DuelInvitation.InvitationResponse> call,
                                  @NonNull Throwable t) {
                consumer.accept(null);
            }
        });
    }

    public void readyForBattle(@NonNull String userId,
                               @NonNull Consumer<Void> consumer) {
        serverInterface.ReadyForBattle(userId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call,
                                   @NonNull Response<Void> response) {
                consumer.accept(null);
            }

            @Override
            public void onFailure(@NonNull Call<Void> call,
                                  @NonNull Throwable t) {
                consumer.accept(null);
            }
        });
    }

    public void stopBattle(@NotNull String userId,
                           @NonNull Consumer<Void> consumer) {
        serverInterface.StopBattle(userId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call,
                                   @NonNull Response<Void> response) {
                consumer.accept(null);
            }

            @Override
            public void onFailure(@NonNull Call<Void> call,
                                  @NonNull Throwable t) {
                consumer.accept(null);
            }
        });
    }

    public void login(@NonNull String userName,
                      @NonNull Consumer<UserAuthDTO.ServerResponseData> consumer) {
        serverInterface.Login(userName).enqueue(new Callback<UserAuthDTO.ServerResponseData>() {
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

    public void updateFCM(@NonNull UserAuthDTO userAuthDTO,
                          @NonNull Consumer<UserAuthDTO.ServerResponseData> consumer) {
        serverInterface.UpdateFCM(userAuthDTO).enqueue(new Callback<UserAuthDTO.ServerResponseData>() {
            @Override
            public void onResponse(@NonNull Call<UserAuthDTO.ServerResponseData> call,
                                   @NonNull Response<UserAuthDTO.ServerResponseData> response) {
                consumer.accept(response.body());
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
                        leaderInfos.sort((o1, o2) -> {
                            if (o1.ELO < o2.ELO) {
                                return 1;
                            } else if (o1.ELO > o2.ELO) {
                                return -1;
                            } else {
                                return 0;
                            }
                        });

                        for (int index = 0; index < leaderInfos.size(); ++index) {
                            leaderInfos.get(index).Number = "#" + index + 1;
                            leaderInfos.get(index).IntNumber = index + 1;
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
