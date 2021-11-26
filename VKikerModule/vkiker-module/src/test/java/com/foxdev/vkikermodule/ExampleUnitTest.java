package com.foxdev.vkikermodule;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import android.util.Log;

import androidx.annotation.NonNull;

import com.foxdev.vkikermodule.net.Endpoints;
import com.foxdev.vkikermodule.net.ServerInterface;
import com.foxdev.vkikermodule.net.VKikerServer;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    static final class TestClass {
        @SerializedName("access")
        public boolean access;

        @SerializedName("test")
        public int value;

        @SerializedName("userId")
        public int userId;
    }

    static final class LeaderboardClass {
        @SerializedName("id")
        public String userId;
        @SerializedName("name")
        public String id;
    }

    static final class UserAuthDTO {
        @SerializedName("userName")
        public String userName;

        @SerializedName("fcmToken")
        public String fcmToken;
    }

    interface TestInterface {
        @GET("/test/access")
        Call<TestClass> testConnection();

        @POST("/auth")
        Call<TestClass> postUser(@Body UserAuthDTO userAuthDTO);

        @GET(Endpoints.LEADERBOARD_ENDPOINT)
        Call<List<LeaderboardClass>> getLeaderboar();
    }

    @Test
    public void testServerConnection() {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .build();

        TestInterface serverInterface = new Retrofit.Builder()
                .baseUrl("http://10.0.6.190:4000/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TestInterface.class);

        try {
            Response<TestClass> response = serverInterface.testConnection().execute();

            Assert.assertTrue(response.body().access);
        } catch (Exception err) {
            Assert.fail();
        }
    }

    @Test
    public void postRandomUser() {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .build();

        TestInterface serverInterface = new Retrofit.Builder()
                .baseUrl("http://10.0.6.190:4000/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TestInterface.class);

        try {
            UserAuthDTO userAuthDTO = new UserAuthDTO();
            userAuthDTO.userName = "Anon";
            userAuthDTO.fcmToken = "It's token";

            Response<TestClass> response = serverInterface
                    .postUser(userAuthDTO).execute();

            Assert.assertTrue(response.body().access);
        } catch (Exception err) {
            Assert.fail();
        }
    }

    @Test
    public void testLeaderboard() {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .build();

        TestInterface serverInterface = new Retrofit.Builder()
                .baseUrl("http://10.0.6.190:4000/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TestInterface.class);

        try {
            serverInterface.getLeaderboar().execute();
        } catch (Exception err) {
            Assert.fail();
        }

    }
}