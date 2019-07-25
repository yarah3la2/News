package com.example.taskandroid.Network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroWeb {

    public static <S> S cteateService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
    static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build();
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null)


        {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;

    }
}
