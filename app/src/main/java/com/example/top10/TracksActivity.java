package com.example.top10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.top10.domen.MyTrackAdapter;
import com.example.top10.domen.Tracks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TracksActivity extends AppCompatActivity {

    private RecyclerView rvTracks;
    private MyTrackAdapter myAdapter;
    private ArrayList<Tracks> mTracks;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);
        getSupportActionBar().hide();

        rvTracks = findViewById(R.id.rvTracks);
        rvTracks.setHasFixedSize(true);
        rvTracks.setLayoutManager(new LinearLayoutManager(this));
        mTracks = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url = "https://api.deezer.com/chart/0/tracks";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("data");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jo1 = jsonArray.getJSONObject(i);
                        String title = jo1.getString("title");
                        String link = jo1.getString("link");
                        int position = jo1.getInt("position");

                        JSONObject jo2 = jo1.getJSONObject("artist");
                        String name = jo2.getString("name");

                        JSONObject jo3 = jo1.getJSONObject("album");
                        String imgURL = jo3.getString("cover_big");

                        Tracks tracks = new Tracks(position, imgURL, title, name, link);
                        mTracks.add(tracks);
                    }

                    myAdapter = new MyTrackAdapter(TracksActivity.this, mTracks);
                    rvTracks.setAdapter(myAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }
}