package com.example.taskandroid.Data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.taskandroid.Network.NewsDao;

@Database(entities = {NewsRoom.class},version = 1)
public abstract class NewsRoomDataBase extends RoomDatabase {
public abstract NewsDao newsDao();
private static NewsRoomDataBase INSTANCE;
    public static synchronized NewsRoomDataBase getDataBase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    NewsRoomDataBase.class, "news_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

}
