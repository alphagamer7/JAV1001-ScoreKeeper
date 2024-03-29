package com.trile.scorekeeper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;


public class ContentFragment extends Fragment {

    TextView team1ScoreTxt;
    TextView team2ScoreTxt;

    Button btnIncreaseTeam1Score;
    Button btnIncreaseTeam2Score;
    Button btnDecreaseTeam1Score;
    Button btnDecreaseTeam2Score;

    RadioGroup team1ScoreRadioGroup;
    RadioGroup team2ScoreRadioGroup;

    int team1Score = 0; // team 1 score to show on UI
    int team2Score = 0; // team 2 score to show on UI
    int team1ScoreChangeBy = 1; // change by value for team 1 score
    int team2ScoreChangeBy = 1; // change by value for team 2 score


    public ContentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        // Inflate the layout for this fragment
        // --------------------------------------------------
        // Set all references for xml elements
        // --------------------------------------------------
        team1ScoreTxt = view.findViewById(R.id.team1Score);
        team2ScoreTxt = view.findViewById(R.id.team2Score);

        btnIncreaseTeam1Score = view.findViewById(R.id.increaseTeam1Score);
        btnIncreaseTeam2Score = view.findViewById(R.id.increaseTeam2Score);
        btnDecreaseTeam1Score = view.findViewById(R.id.decreaseTeam1Score);
        btnDecreaseTeam2Score = view.findViewById(R.id.decreaseTeam2Score);

        team1ScoreRadioGroup = view.findViewById(R.id.team1ScoreRadioGroup);
        team2ScoreRadioGroup = view.findViewById(R.id.team2ScoreRadioGroup);

        // --------------------------------------------------
        // Set all listeners for xml elements
        // --------------------------------------------------
        setupButtonListeners();
        setupRadioButtonListeners();
        return view;
    }



    private void setupButtonListeners() {
        // Increase and Decrease buttons for team 1 and 2 scores
        btnIncreaseTeam1Score.setOnClickListener(view -> {
            team1Score += team1ScoreChangeBy;
            team1ScoreTxt.setText("Score 1: " + team1Score);
        });
        btnIncreaseTeam2Score.setOnClickListener(view -> {
            team2Score += team2ScoreChangeBy;
            team2ScoreTxt.setText("Score 2: " + team2Score);
        });
        btnDecreaseTeam1Score.setOnClickListener(view -> {
            team1Score -= team1ScoreChangeBy;
            team1ScoreTxt.setText("Score 1: " + team1Score);
        });
        btnDecreaseTeam2Score.setOnClickListener(view -> {
            team2Score -= team2ScoreChangeBy;
            team2ScoreTxt.setText("Score 2: " + team2Score);
        });
    }

    private void setupRadioButtonListeners() {
        // Radio Groups for Team 1 change by score
        team1ScoreRadioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            // Set the change by value for team 1 score when user select a radio button
            switch (checkedId) {
                case R.id.team1Score1RadioBtn:
                    team1ScoreChangeBy = 1;
                    break;
                case R.id.team1Score50RadioBtn:
                    team1ScoreChangeBy = 50;
                    break;
                case R.id.team1Score99RadioBtn:
                    team1ScoreChangeBy = 99;
                    break;
            }
        });
        // Radio Groups for Team 2 change by score
        team2ScoreRadioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            // Set the change by value for team 2 score when user select a radio button
            switch (checkedId) {
                case R.id.team2Score1RadioBtn:
                    team2ScoreChangeBy = 1;
                    break;
                case R.id.team2Score50RadioBtn:
                    team2ScoreChangeBy = 50;
                    break;
                case R.id.team2Score99RadioBtn:
                    team2ScoreChangeBy = 99;
                    break;
            }
        });
    }
}