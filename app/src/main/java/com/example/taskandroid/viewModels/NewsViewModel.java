package com.example.taskandroid.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.taskandroid.Data.News;
import com.example.taskandroid.Data.NewsRoom;
import com.example.taskandroid.Network.NewsReprository;

import java.util.List;

public class NewsViewModel extends AndroidViewModel {
    private MutableLiveData<News> mutableLiveData;
    private NewsReprository newsReprository;


    public void init(){
        if (mutableLiveData != null){
            return;
        }
        newsReprository = NewsReprository.getInstance();

    }

    private LiveData<List<NewsRoom>> allNews;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        newsReprository = new NewsReprository(application);
        allNews = newsReprository.getAllNews();
    }

    public MutableLiveData<News> getNewsRepository() {
        return mutableLiveData;
    }
    public void insert (NewsRoom newsRoom){newsReprository.insert(newsRoom);}

}
