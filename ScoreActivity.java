package com.example.hw_12;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hw_12.Model.Score;
import com.example.hw_12.Views.ListFragment;
import com.google.android.material.textview.MaterialTextView;
import java.util.Timer;
import java.util.TimerTask;

public class ScoreActivity extends AppCompatActivity {
    public static final String NAME_KEY = "NAME_KEY";
    public static final String KEY_STATUS = "KEY_STATUS";
    public static final String KEY_SCORE = "KEY_SCORE";

    private MaterialTextView score_LBL_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        findViews();

        Intent previousScreen = getIntent();

        String status = previousScreen.getStringExtra(NAME_KEY);
        int score = previousScreen.getIntExtra(KEY_SCORE,0);

        refreshUI(status, score);

    }

    private void refreshUI(String status, int score) {
        score_LBL_score.setText(status + "\n" + score);
        DataManager.addScore(new Score("eti", score,8.58,9.56));

        new Timer().schedule(new TimerTask(){

            @Override
            public void run(){
            }

        }, 5000);

        changeRecordsActivity();

    }

    private void findViews() {
        score_LBL_score = findViewById(R.id.score_LBL_score);
    }


    private void changeRecordsActivity() {
        Intent recordsListIntent = new Intent(this,RecordsActivity.class);
        startActivity(recordsListIntent);
        finish();
    }




}
