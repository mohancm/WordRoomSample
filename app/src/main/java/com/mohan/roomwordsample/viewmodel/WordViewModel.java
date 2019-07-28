package com.mohan.roomwordsample.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mohan.roomwordsample.Model.Word;
import com.mohan.roomwordsample.WordRepository;

import java.util.List;

/**
 * Created by @mohancm on 28-07-2019 11:38 PM.
 */
public class WordViewModel extends AndroidViewModel {

    private WordRepository mWordRepository;

    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mWordRepository = new WordRepository(application);
        mAllWords = mWordRepository.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    // Create a wrapper insert() method that calls the Repository's insert() method.
    // this implementation of insert() is completely hidden from the UI.

    public void insert(Word word) {
        mWordRepository.insert(word);
    }

}
