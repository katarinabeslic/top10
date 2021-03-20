package com.example.top10.domen;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.top10.R;


public class TracksButton {

    private CardView cardView;
    private ProgressBar progressBar;
    private ConstraintLayout constraintLayout;
    private TextView textView;

    public TracksButton(Context context, View view){
        cardView = view.findViewById(R.id.cardView);
        progressBar = view.findViewById(R.id.progressBar);
        constraintLayout = view.findViewById(R.id.constraintLayout);
        textView = view.findViewById(R.id.textView);
    }

    public void buttonActivated(){
        progressBar.setVisibility(View.VISIBLE);
        textView.setText("Please wait...");
    }

    public void buttonFinish(){
        constraintLayout.setBackgroundColor(cardView.getResources().getColor(R.color.pink));
        progressBar.setVisibility(View.GONE);
        textView.setText("Done");
    }
}
