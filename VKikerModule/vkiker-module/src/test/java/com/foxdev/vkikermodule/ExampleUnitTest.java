package com.foxdev.vkikermodule;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import android.util.Log;

import com.foxdev.vkikermodule.net.ServerInterface;
import com.foxdev.vkikermodule.net.VKikerServer;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.function.Consumer;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    static final class TestClass {
        @SerializedName("test")
        public int value;
    }

    interface TestInterface {
        @GET("/test")
        Call<TestClass> testConnection();
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

            Assert.assertTrue(response.body().value == 0);
        } catch (Exception err) {
            Assert.fail();
        }
    }
}