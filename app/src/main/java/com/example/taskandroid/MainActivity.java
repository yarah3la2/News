package com.example.taskandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.taskandroid.Adapters.NewsAdapter;
import com.example.taskandroid.Data.Article;
import com.example.taskandroid.Data.News;
import com.example.taskandroid.Network.ApiInterface;
import com.example.taskandroid.Network.RetroWeb;
import com.example.taskandroid.viewModels.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Article> articleArrayList = new ArrayList<>();
    NewsAdapter newsAdapter;
    RecyclerView rvHeadline;
    NewsViewModel newsViewModel;
    SearchView search_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvHeadline = (RecyclerView) findViewById(R.id.news_recycleview);
        search_news = (SearchView) findViewById(R.id.search_news);
        search_news.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });

        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        newsViewModel.init();
        newsViewModel.getNewsRepository().observe(this, new Observer<News>() {
            @Override
            public void onChanged(News news) {
              getNew();
            }
        });

    }



    public void getNew()
    {
        ApiInterface apiService = RetroWeb.getClient().create(ApiInterface.class);
        final Call<List<Article>> listCall =apiService.getNews("google-news","API_KEY");
        listCall.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                showIt(response.body());


            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {

            }
        });
    }

    public void showIt(List<Article> response)
    {
        RecyclerView.Adapter newsAdapter = new NewsAdapter(getApplicationContext(),response);
        rvHeadline.setAdapter(newsAdapter);
    }
    }

