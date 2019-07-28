package com.mohan.roomwordsample;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.mohan.roomwordsample.Model.Word;
import com.mohan.roomwordsample.db.WordDao;
import com.mohan.roomwordsample.db.WordRoomDatabase;

import java.util.List;

/**
 * Created by @mohancm on 28-07-2019 11:21 PM.
 */
public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    // add a constructor that gets a handle to the database
    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();

        }
        /**
        Add a wrapper for getAllWords(). Room executes all queries on a
        separate thread. Observed LiveData will notify thw observer when the data has changed.
        */
    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    // Add a wrapper for the insert() method.
    public void insert (Word word){
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
