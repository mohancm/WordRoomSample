package com.mohan.roomwordsample.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mohan.roomwordsample.Model.Word;

/**
 * Created by @mohancm on 28-07-2019 11:09 PM.
 */
@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {
    public abstract WordDao wordDao();
}
