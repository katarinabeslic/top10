package com.example.top10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.top10.domen.TracksButton;

public class MainActivity extends AppCompatActivity {

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        view = findViewById(R.id.btnTracks);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TracksButton tb = new TracksButton(MainActivity.this, view);
                tb.buttonActivated();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tb.buttonFinish();
                        Handler h2 = new Handler();
                        h2.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(MainActivity.this, TracksActivity.class);
                                startActivity(intent);
                            }
                        }, 500);
                    }
                }, 3000);
            }
        });

    }

    public void openTracks(View view) {
        Intent intent = new Intent(MainActivity.this, TracksActivity.class);
        startActivity(intent);
        finish();
    }
}