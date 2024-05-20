package com.example.hw_12;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.hw_12.Interfaces.Callback_highScoreClicked;
import com.example.hw_12.Model.Score;
import com.example.hw_12.Views.ListFragment;
import com.example.hw_12.Views.MapFragment;

public class RecordsActivity extends AppCompatActivity {

    private FrameLayout records_FRAME_list;
    private FrameLayout records_FRAME_map;

    private MapFragment mapFragment;
    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        findViews();

        listFragment = new ListFragment();
        listFragment.setCallbackHighScoreClicked(new Callback_highScoreClicked() {
            @Override
            public void mapZoomClicked(double lat, double lon) {
                mapFragment.zoom(lat,lon);
            }


        });
        mapFragment = new MapFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.records_FRAME_list, listFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.records_FRAME_map, mapFragment).commit();


    }

    private void findViews() {

        records_FRAME_list = findViewById(R.id.records_FRAME_list);
        records_FRAME_map = findViewById(R.id.records_FRAME_map);
    }
}