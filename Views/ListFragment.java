package com.example.hw_12.Views;

import static android.content.Intent.getIntent;
import static android.content.Intent.parseUri;

import static com.example.hw_12.ScoreActivity.KEY_SCORE;
import static com.example.hw_12.ScoreActivity.NAME_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw_12.Adapters.ScoreListAdapter;
import com.example.hw_12.DataManager;
import com.example.hw_12.Interfaces.Callback_highScoreClicked;
import com.example.hw_12.Model.Score;
import com.example.hw_12.R;
import android.content.Intent;

import java.util.ArrayList;
import android.util.Log;


public class ListFragment extends Fragment {

    private RecyclerView list_LST_records;
    private Callback_highScoreClicked callbackHighScoreClicked;


    public ListFragment() {
    }

    public void setCallbackHighScoreClicked(Callback_highScoreClicked callbackHighScoreClicked) {
        this.callbackHighScoreClicked = callbackHighScoreClicked;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        findViews(view);
        DataManager.setUpModel();
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        Log.i("myApp", "hallo");
        ScoreListAdapter listAdapter = new ScoreListAdapter(view.getContext(), DataManager.getSortRecords(), callbackHighScoreClicked);
        list_LST_records.setAdapter(listAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        list_LST_records.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);


    }

    private void createListData() {
        //adding the data to recycle
    }




    private void findViews(View view) {
        //list_LBL_title = view.findViewById(R.id.list_LBL_title);
        //list_BTN_send = view.findViewById(R.id.list_BTN_send);
        list_LST_records=view.findViewById(R.id.list_LST_list);
    }


}