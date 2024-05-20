package com.example.hw_12;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.content.Intent;
import android.widget.ImageButton;

import java.util.Random;

import com.example.hw_12.Logic.GameManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {


    private static final long DELAY = 1000;
    final Handler handler = new Handler();
    private boolean timerOn = false;

    private MaterialTextView main_LBL_score;
    private ShapeableImageView[] main_IMG_hearts;
    private ShapeableImageView[][] main_IMG_matrix;
    private ShapeableImageView[] main_IMG_player;
    private ImageButton main_BTN_right;
    private ImageButton main_BTN_left;

    public GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataManager.init();
        findViews();
        //start game
        gameManager = new GameManager(main_IMG_hearts.length);


        //start timer
        startTimer();
        refreshUI();
        main_BTN_right.setOnClickListener(view -> playerMove(gameManager.getCurrentLocation()+1));
        main_BTN_left.setOnClickListener(view -> playerMove(gameManager.getCurrentLocation()-1));

    }

    private void playerMove(int newLocation) {
        if (newLocation > 4)
            gameManager.setCurrentLocation(4);
        if (newLocation < 0)
            gameManager.setCurrentLocation(0);
        else
            gameManager.setCurrentLocation(newLocation);





    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this, DELAY);
            newImageLine();
            gameManager.isCrushed();
            refreshUI();


        }
    };


    private void stopTimer() {
        timerOn = false;
        handler.removeCallbacks(runnable);
    }

    private void startTimer() {
        if (!timerOn) {
            timerOn = true;
            handler.postDelayed(runnable, 0);
        }
    }

    @SuppressLint("ResourceType")
    private int newImageLine() {

        Random rand = new Random();
        int location = rand.nextInt(10);
        if (location<5){ //obsticles
            location=location/2;
            main_IMG_matrix[location][0].setImageResource(R.drawable.big_brother);
        }
        else{ //coins
            location=location/2;
            //main_IMG_matrix[location][0].setImageResource(R.drawable.milk);

        }
        for(int i=4;i>0;i--){
            for(int j=0;j<5;j++){
                if( main_IMG_matrix[j][i-1].getVisibility() == View.VISIBLE)
                {
                    main_IMG_matrix[j][i].setVisibility(View.VISIBLE);
                    main_IMG_matrix[j][i-1].setVisibility(View.INVISIBLE);
                    if (i==4){
                        gameManager.setImageLocation(j);
                    }
                }
                else{
                    main_IMG_matrix[j][i].setVisibility(View.INVISIBLE);

            }


            }

        }
        main_IMG_matrix[location][0].setVisibility(View.VISIBLE);
        return location;

        }



    private void refreshUI() {
        // lost:
        if (gameManager.isGameLost()) {
            stopTimer();
            changeActivity("GAME OVER", gameManager.getScore());

        }

            // game on:
        else {
            //refresh score
            main_LBL_score.setText(gameManager.getScore() + "");
            //refresh heart
            if (gameManager.getWrongAnswers() != 0)
                main_IMG_hearts[main_IMG_hearts.length - gameManager.getWrongAnswers()].setVisibility(View.INVISIBLE);
            //refresh player location
            for (int i=0;i<5;i++){
                if (i==gameManager.getCurrentLocation()){
                    main_IMG_player[i].setVisibility(View.VISIBLE);
                }
                else
                    main_IMG_player[i].setVisibility(View.INVISIBLE);

            }
        }
    }

    private void changeActivity(String status, int score) {
        Intent scoreIntent = new Intent(this, ScoreActivity.class);
        scoreIntent.putExtra(ScoreActivity.KEY_STATUS, status);
        scoreIntent.putExtra(ScoreActivity.KEY_SCORE, score);
        startActivity(scoreIntent);
        finish();
    }



    private void findViews() {
        main_LBL_score = findViewById(R.id.main_LBL_score);
        main_IMG_hearts=new ShapeableImageView[]{
                findViewById(R.id.main_IMG_heart1),
                findViewById(R.id.main_IMG_heart2),
                findViewById(R.id.main_IMG_heart3)
        };

        main_IMG_matrix= new ShapeableImageView[][]{
                new ShapeableImageView[]{
                        findViewById(R.id.main_IMV_0_0),
                        findViewById(R.id.main_IMV_1_0),
                        findViewById(R.id.main_IMV_2_0),
                        findViewById(R.id.main_IMV_3_0),
                        findViewById(R.id.main_IMV_4_0)
                },
                new ShapeableImageView[]{
                        findViewById(R.id.main_IMV_0_1),
                        findViewById(R.id.main_IMV_1_1),
                        findViewById(R.id.main_IMV_2_1),
                        findViewById(R.id.main_IMV_3_1),
                        findViewById(R.id.main_IMV_4_1)
                },
                new ShapeableImageView[]{
                        findViewById(R.id.main_IMV_0_2),
                        findViewById(R.id.main_IMV_1_2),
                        findViewById(R.id.main_IMV_2_2),
                        findViewById(R.id.main_IMV_3_2),
                        findViewById(R.id.main_IMV_4_2)
                },
                new ShapeableImageView[]{
                        findViewById(R.id.main_IMV_0_3),
                        findViewById(R.id.main_IMV_1_3),
                        findViewById(R.id.main_IMV_2_3),
                        findViewById(R.id.main_IMV_3_3),
                        findViewById(R.id.main_IMV_4_3)
                },
                new ShapeableImageView[]{
                        findViewById(R.id.main_IMV_0_4),
                        findViewById(R.id.main_IMV_1_4),
                        findViewById(R.id.main_IMV_2_4),
                        findViewById(R.id.main_IMV_3_4),
                        findViewById(R.id.main_IMV_4_4)
                }
        };


        main_IMG_player = new ShapeableImageView[]{
                findViewById(R.id.main_baby_position_0),
                findViewById(R.id.main_baby_position_1),
                findViewById(R.id.main_baby_position_2),
                findViewById(R.id.main_baby_position_3),
                findViewById(R.id.main_baby_position_4)
        };

        main_BTN_right = findViewById(R.id.main_BTN_right);
        main_BTN_left = findViewById(R.id.main_BTN_left);

    }


}