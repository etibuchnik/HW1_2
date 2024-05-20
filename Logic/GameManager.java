package com.example.hw_12.Logic;

import com.example.hw_12.DataManager;
import com.example.hw_12.SignalManager;

import java.util.ArrayList;
import java.util.Map;

public class GameManager {


    private static final int ANSWER_POINTS = 10;
    private int score = 0;
    private int wrongAnswers = 0;
    private int life;
    private int currentLocation;
    private int imageLocation;
    public ArrayList recordsList;




    public GameManager() {
        this.life = 3;
        currentLocation = 2;
        DataManager.setUpModel();


    }

    public GameManager(int life) {
        this.life = life;
        currentLocation = 2;
        DataManager.setUpModel();

    }


    public int getImageLocation() {
        return imageLocation;
    }

    public GameManager setImageLocation(int imageLocation) {
        this.imageLocation = imageLocation;
        return this;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public GameManager setCurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
        return this;
    }

    public int getScore() {
        return score;
    }


    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public int getLife() {
        return life;
    }



    public boolean isGameLost (){
        return getLife() == getWrongAnswers();
    }

    public void isCrushed(){
        if (getCurrentLocation() != getImageLocation())
            score += ANSWER_POINTS;
        else {
            wrongAnswers++;
            //SignalManager.getInstance().vibrate(500);
           // SignalManager.getInstance().toast("YOU CRUSHED!!");

        }

    }


}








