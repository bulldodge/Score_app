// Natalie Arner
// Score Keeper
/* The app keeps the score of two teams, home and away by default,
 that you can change the name of. Either give or take points by pressing the buttons,
 or reset the scores. It attempts to save your scores and team names. */


package com.example.scorekeeperna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private int foul_b = 0;
    private int foul_a = 0;

    //public static final String A_SCORE_KEY= "scoreTeamA";
    //public static final String B_SCORE_KEY= "scoreTeamB";

    public static final String A_SCORE_KEY= "scoreTeamA";
    public static final String B_SCORE_KEY= "scoreTeamB";
    public static final String A_FOUL_KEY= "scoreTeamA";
    public static final String B_FOUL_KEY= "scoreTeamB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team A.
     */
    public void pointForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }



    public void FoulForTeamA(View v) {
        foul_a = foul_a + 1;
        String sA = "Total Foul : " + foul_a;
        scoreTeamA = scoreTeamA - 1;
        displayForTeamA(scoreTeamA);
        foulA(sA);
    }

    public void foulA(String f) {
        TextView scoreView = (TextView) findViewById(R.id.foul_a);
        scoreView.setText(String.valueOf(f));
    }

    /**
     * Displays the given score for Team B.
     */

    public void addPointForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void FoulForTeamB(View v) {
        foul_b = foul_b + 1;
        String sB = "Total Foul : " + foul_b;
        scoreTeamB = scoreTeamB - 1;
        displayForTeamB(scoreTeamB);
        foulB(sB);
    }

    public void foulB(String foul) {
        TextView scoreView = (TextView) findViewById(R.id.foul_b);
        scoreView.setText(String.valueOf(foul));
    }

    public void resetScore(View v) {
        scoreTeamB = 0;
        scoreTeamA = 0;
        foul_b = 0;
        foul_a = 0;
        String s = "Total Foul : " + 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        foulA(s);
        foulB(s);
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putLong(A_SCORE_KEY, scoreTeamA);
        savedInstanceState.putLong(B_SCORE_KEY, scoreTeamB);
        savedInstanceState.putLong(A_FOUL_KEY, foul_a);
        savedInstanceState.putLong(B_FOUL_KEY, foul_b);
    }
}