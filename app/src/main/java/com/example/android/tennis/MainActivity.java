package com.example.android.tennis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA=0;
    int scoreTeamB=0;
    int SA=0;
    int SB=0;
    ArrayList<String> score=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score.add("0");
        score.add("15");
        score.add("30");
        score.add("40");
        score.add("A");
        displayForTeamA(score.get(scoreTeamA));
        displayForTeamB(score.get(scoreTeamB));
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(String score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score_small);
        scoreView.setText(String.valueOf(score));
        TextView scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewA.setText(String.valueOf(SA));
    }
    public void displayForTeamB(String score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score_small);
        scoreView.setText(String.valueOf(score));
        TextView scoreViewB = (TextView) findViewById(R.id.team_b_score);
        scoreViewB.setText(String.valueOf(SB));
    }
    private void reset() {
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamA(score.get(scoreTeamA));
        displayForTeamB(score.get(scoreTeamB));
    }
    public void AOne(View view){

        if(scoreTeamA>=2&&(scoreTeamA+1-scoreTeamB)>1){
            SA++;
            reset();
        }
        else if (scoreTeamA==4&&scoreTeamB==4){
            scoreTeamB--;
        }
        else{
            scoreTeamA++;
        }
        displayForTeamA(score.get(scoreTeamA));
        displayForTeamB(score.get(scoreTeamB));


    }

    public void BOne(View view){
        if(scoreTeamB>=2&&(scoreTeamB+1-scoreTeamA)>1){
            SB++;
            reset();
        }
        else if (scoreTeamB==4&&scoreTeamA==4){
            scoreTeamA--;
        }
        else{
            scoreTeamB++;
        }
        displayForTeamA(score.get(scoreTeamA));
        displayForTeamB(score.get(scoreTeamB));
    }
    public void AFault(View view){
        BOne(view);
    }
    public void BFault(View view){
        AOne(view);
    }

    public void reset(View view){
        scoreTeamA=0;
        scoreTeamB=0;
        SA=0;
        SB=0;
        displayForTeamA(score.get(scoreTeamA));
        displayForTeamB(score.get(scoreTeamB));
    }
}
