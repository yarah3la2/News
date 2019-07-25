package com.example.taskandroid.Network;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.taskandroid.Data.NewsRoom;

import java.util.List;

@Dao
public interface  NewsDao {
     @Query("SELECT * from news_table")
    LiveData<List<NewsRoom>> getNewsRoom();

     @Insert()
    void insert (NewsRoom newsRoom);

}
