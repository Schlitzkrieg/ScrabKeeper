package com.schlitzkrieg.scrabkeeper;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by jdsch on 2/26/2018.
 */

public class WordChecker {

    ArrayList words;

    WordChecker(Context context){
        this.words = loadWordList(context);
    }

    private ArrayList loadWordList(Context context){
        ArrayList<String> wordFile = new ArrayList<String>();

        InputStream inputStream = context.getResources().openRawResource(R.raw.wordlisting);
        BufferedReader r = new BufferedReader(new InputStreamReader((inputStream)));

        String line = null;

        try{
            while((line = r.readLine()) != null) {
                wordFile.add(line);
            }
        }catch (IOException e){
            Log.d("wordlisting load failed", e.toString());
        }

        return wordFile;
    }


}
