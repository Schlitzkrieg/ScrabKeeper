package com.schlitzkrieg.scrabkeeper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button btnWordCheck;
    public Button btnP1Add;
    public Button btnP2Add;
    public Button btnP3Add;
    public Button btnP4Add;

    public TextView p1Score;
    public TextView p2Score;
    public TextView p3Score;
    public TextView p4Score;

    ScoreKeeper scoreKeeper = new ScoreKeeper(0, 0,0,0);
    WordChecker wc = new WordChecker(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO: Find out why onCreate is not being entered at runtime
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wc = new WordChecker(this);
        setupControls();


    }

    void setupControls(){
        btnWordCheck = findViewById((R.id.btnWordCheck));
        btnP1Add = findViewById(R.id.btnP1add);
        btnP2Add = findViewById(R.id.btnP2add);
        btnP3Add = findViewById(R.id.btnP3add);
        btnP4Add = findViewById(R.id.btnP4add);

        p1Score = findViewById(R.id.vwP1score);
        p2Score = findViewById(R.id.vwP2score);
        p3Score = findViewById(R.id.vwP3score);
        p4Score = findViewById(R.id.vwP4score);
        refreshScores();

        btnWordCheck.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               //do nothing for now
            }
        });

        btnP1Add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                showScorePrompt((1));
            }
        });

        btnP2Add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                showScorePrompt((2));
            }
        });

        btnP3Add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                showScorePrompt((3));
            }
        });

        btnP4Add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                showScorePrompt((4));
            }
        });
    }

    void showScorePrompt(final int playerNum){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Enter Word Score for player " + Integer.toString(playerNum));
        final EditText input = new EditText(MainActivity.this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(input.getText().length() > 0){
                    int points = Integer.parseInt(input.getText().toString());

                    if(playerNum == 1){
                        scoreKeeper.Player1Score = scoreKeeper.Player1Score + points;
                    }else if(playerNum == 2){
                        scoreKeeper.Player2Score = scoreKeeper.Player2Score + points;
                    }else if(playerNum == 3){
                        scoreKeeper.Player3Score = scoreKeeper.Player3Score + points;
                    }else if(playerNum == 4){
                        scoreKeeper.Player4Score = scoreKeeper.Player4Score + points;
                    }
                    refreshScores();
                }else{
                    Log.d("NO TEXT DETECTED", "NO TEXT DETECTED");
                }


            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    void refreshScores(){
        //System.console().printf("am I broken here?");
        p1Score.setText(Integer.toString(scoreKeeper.Player1Score));
        p2Score.setText(Integer.toString(scoreKeeper.Player2Score));
        p3Score.setText(Integer.toString(scoreKeeper.Player3Score));
        p4Score.setText(Integer.toString(scoreKeeper.Player4Score));
    }

}
