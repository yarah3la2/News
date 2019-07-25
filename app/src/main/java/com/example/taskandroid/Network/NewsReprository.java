package com.example.taskandroid.Network;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import com.example.taskandroid.Data.NewsRoom;
import com.example.taskandroid.Data.NewsRoomDataBase;

import java.util.List;

public class NewsReprository {
    private static NewsReprository newsReprository;
    private ApiInterface apiService;
    private NewsDao newsDao;
    LiveData<List<NewsRoom>> allNews;
    static Application application;

    public static NewsReprository getInstance(){
        if (newsReprository == null){
            newsReprository = new NewsReprository(application);
        }
        return newsReprository;
    }



    public NewsReprository(Application application){

        NewsRoomDataBase db= NewsRoomDataBase.getDataBase(application);
        newsDao=db.newsDao();
        allNews=newsDao.getNewsRoom();



    }
public LiveData<List<NewsRoom>> getAllNews(){return allNews;}
public void insert (NewsRoom newsRoom){new insertAsynTask(newsDao).execute(newsRoom);}
public static class insertAsynTask extends AsyncTask<NewsRoom,Void,Void>{
    private NewsDao newsAsynTaskDao;

    public insertAsynTask(NewsDao newsAsynTaskDao) {
        this.newsAsynTaskDao = newsAsynTaskDao;
    }

    @Override
    protected Void doInBackground(NewsRoom... newsRooms) {
        newsAsynTaskDao.insert(newsRooms[0]);
        return null;

    }
}

}
