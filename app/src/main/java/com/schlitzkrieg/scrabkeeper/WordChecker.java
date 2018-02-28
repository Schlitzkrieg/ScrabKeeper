package com.schlitzkrieg.scrabkeeper;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * Created by jdsch on 2/26/2018.
 */

public class WordChecker {

    ArrayList words;

    WordChecker(Context context){
        this.words = loadWordList(context);
    }

    ArrayList loadWordList(Context context){
        ArrayList<String> wordFile = new ArrayList<String>();

        InputStream inputStream = context.getResources().openRawResource(R.raw.wordlisting);
        BufferedReader r = new BufferedReader(new InputStreamReader((inputStream)));

        String line;

        try{
            line = r.readLine();
        }catch (IOException e){
            Log.d("wordlisting load failed", e.toString());
        }

        for (String s : wordFile){
            words.add(s);
        }

        return wordFile;
    }


}
