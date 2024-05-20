package com.example.hw_12;

import com.example.hw_12.Model.Score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataManager {

    public static HashMap<Integer,String> sortRecords;
    public static ArrayList<Score> TopScores;


    public static void init(){
        TopScores = new ArrayList<Score>();
        sortRecords = new HashMap<>();
        TopScores.add(new Score("אתי בוכניק",100, 3.25,4.25));
        TopScores.add(new Score("אדוה בוכניק",150, 5.36,98.6));
        TopScores.add(new Score("שמואל בוכניק",190,89.23,78.56));
        TopScores.add(new Score("נועה כהן",20,8.25,8.25));
        TopScores.add(new Score("איתי קדוש",80,1.23,4.56));
        TopScores.add(new Score("אורי קדוש",250,98.56,7.58));
        TopScores.add(new Score("אופק קדוש",190,8.124,56.3));
        TopScores.add(new Score("עדן ארבל",320,25.25,45.26));
        TopScores.add(new Score("שי בוניאק",10,89.25,71.25));
        TopScores.add(new Score("פטריק בוניאק",650,0.25,9.23));
    }
    public static void setUpModel(){


        getSortRecords();
        for (int i=0;i<10;i++){
            sortRecords.put(TopScores.get(i).getScore(),TopScores.get(i).getName() );
        }


    }
    public static ArrayList getSortRecords() {

        //Collections.sort(TopScores, Comparator.comparing(Score::getScore));

        return TopScores;
    }

    public static ArrayList<Score> getTopScores() {
        return TopScores;
    }

    public static ArrayList addScore(Score newScore) {
        Score minScore = TopScores.get(0);
        if (newScore.getScore() > minScore.getScore())
        {
            TopScores.remove(0);
            sortRecords.remove(minScore.getScore());
            TopScores.add(newScore);
            sortRecords.put(newScore.getScore(), newScore.getName());
        }
        return TopScores;
    }




}
