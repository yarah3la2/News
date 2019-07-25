package com.example.taskandroid.Network;


import com.example.taskandroid.Data.Article;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @FormUrlEncoded
    @GET("top-headlines")
    Call<List<Article>> getNews(@Query("sources") String newsSource,
                             @Query("apiKey") String apiKey);


}
