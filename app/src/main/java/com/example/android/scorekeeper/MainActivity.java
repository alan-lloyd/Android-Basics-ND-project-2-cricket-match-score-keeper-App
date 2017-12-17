package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //runs total at start of the game
    int runsHomeTeam = 0;
    int runsVisitingTeam = 0;

    //the team batting typically starts with 11 players
    int batsmenLeftHomeTeam = 11;
    int batsmenLeftVisitingTeam = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Home team.
     */
    public void displayForHomeTeam(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_team_runs);
        scoreView.setText(String.valueOf(score));
    }

    //for 6 runs (bats ball out of the pitch, without touching the ground)
    public void addSixRunsHomeTeam(View v) {
        runsHomeTeam = runsHomeTeam + 6;
        displayForHomeTeam(runsHomeTeam);
    }

    //for 4 runs (bats ball out of the pitch, touching the ground)
    public void addFourRunsHomeTeam(View v) {
        runsHomeTeam = runsHomeTeam + 4;
        displayForHomeTeam(runsHomeTeam);
    }

    //for 1,2,3,5,7 or more runs (typically 1 or 2)
    public void addOneRunHomeTeam(View v) {
        runsHomeTeam = runsHomeTeam + 1;
        displayForHomeTeam(runsHomeTeam);
    }

    /**
     * Displays the given score for Visiting team.
     */
    public void displayForVisitors(int score) {
        TextView scoreView = (TextView) findViewById(R.id.visiting_team_runs);
        scoreView.setText(String.valueOf(score));
    }

    //for 6 runs
    public void addSixRunsVisitors(View v) {
        runsVisitingTeam = runsVisitingTeam + 6;
        displayForVisitors(runsVisitingTeam);
    }

    //for 4 runs
    public void addFourRunsVisitors(View v) {
        runsVisitingTeam = runsVisitingTeam + 4;
        displayForVisitors(runsVisitingTeam);
    }

    //for 1,2,3,5,7 or more runs
    public void addOneRunVisitors(View v) {
        runsVisitingTeam = runsVisitingTeam + 1;
        displayForVisitors(runsVisitingTeam);
    }


    //button on click decrements instance variable value holding number of remaining Home Team batsmen
    public void deductOneBatsmanHomeTeam(View v) {
        if (batsmenLeftHomeTeam > 0) {
            batsmenLeftHomeTeam = batsmenLeftHomeTeam - 1;
            displayRemainingBatsmenForHomeTeam(batsmenLeftHomeTeam);
        }

    }

    //called by deductOneBatsmanHomeTeam method, to display updated remaining Home Team batsmen total
    public void displayRemainingBatsmenForHomeTeam(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_team_remaining_batsmen);
        scoreView.setText(String.valueOf(score));
    }

    //button on click decrements instance variable value holding number of remaining Visiting Team batsmen
    public void deductOneBatsmanVisitors(View v) {
        if (batsmenLeftVisitingTeam > 0) {
            batsmenLeftVisitingTeam = batsmenLeftVisitingTeam - 1;
            displayRemainingBatsmenForVisitingTeam(batsmenLeftVisitingTeam);
        }
    }

    //called by deductOneBatsmanVisitors method, to display updated remaining Visiting Team batsmen total
    public void displayRemainingBatsmenForVisitingTeam(int score) {
        TextView scoreView = (TextView) findViewById(R.id.visitors_remaining_batsmen);
        scoreView.setText(String.valueOf(score));
    }

    //on pressing 'reset' button method resets global variables to default ('0' score; '11' batsmen), then displays reset values
    public void resetScoresAndBatsmen(View v) {
        runsHomeTeam = 0;
        runsVisitingTeam = 0;
        batsmenLeftHomeTeam = 11;
        batsmenLeftVisitingTeam = 11;
        displayForHomeTeam(runsHomeTeam);
        displayForVisitors(runsVisitingTeam);
        displayRemainingBatsmenForHomeTeam(batsmenLeftHomeTeam);
        displayRemainingBatsmenForVisitingTeam(batsmenLeftVisitingTeam);
    }
}