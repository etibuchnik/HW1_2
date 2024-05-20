package com.example.hw_12.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw_12.Interfaces.Callback_highScoreClicked;
import com.example.hw_12.Model.Score;
import com.example.hw_12.R;

import java.util.ArrayList;

public class ScoreListAdapter extends RecyclerView.Adapter<ScoreListAdapter.RecordsListViewHolder> {
    private Context context;
    private ArrayList<Score> records;
    private Callback_highScoreClicked recordCallback;


    public ScoreListAdapter(Context context, ArrayList<Score> records, Callback_highScoreClicked callbackHighScoreClicked) {
        this.context = context;
        this.records = records;
        recordCallback=callbackHighScoreClicked;
    }


    @NonNull
    @Override
    public RecordsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout and giving a look to our items
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_score, parent, false);
        return new ScoreListAdapter.RecordsListViewHolder(view,recordCallback);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordsListViewHolder holder, int position) {
        //assign vals to our rows based on there position
        int number = position+1;
        holder.txtPosition.setText("#" + number + "");
        holder.txtScore.setText(records.get(position).getScore()+ "");
        holder.txtName.setText(records.get(position).getName());
        holder.BTNmapZoom.setOnClickListener(v -> itemClicked(records.get(position)));


    }
    private void itemClicked(Score score) {
        if (recordCallback != null)
            recordCallback.mapZoomClicked(score.getLat(), score.getLon());
    }







    @Override
    public int getItemCount() {
        //number of items to display
        return 10;
    }

    public static class RecordsListViewHolder extends RecyclerView.ViewHolder{
        //grabbing the views from the recycler layout
        TextView txtName, txtScore, txtPosition;
        ImageButton BTNmapZoom;
        Callback_highScoreClicked recordCallback;



        public RecordsListViewHolder(View itemView,Callback_highScoreClicked recordCallback ){
            super(itemView);
            txtPosition= itemView.findViewById(R.id.item_TXT_number);
            txtName=itemView.findViewById(R.id.item_TXT_name);
            txtScore=itemView.findViewById(R.id.item_TXT_score);
            BTNmapZoom=itemView.findViewById(R.id.item_BTN_mapZoom);
            this.recordCallback=recordCallback;


        }







    }

}
