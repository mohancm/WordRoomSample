package com.mohan.roomwordsample.Model;

import androidx.annotation.NonNull;

/**
 * Created by @mohancm on 28-07-2019 09:14 PM.
 */
public class Word {

    private String mWord;

    public Word(@NonNull String word) {
        this.mWord = word;

    }

    public String getWord() {
        return this.mWord;
    }
}
