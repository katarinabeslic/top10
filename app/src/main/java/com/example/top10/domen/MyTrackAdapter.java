package com.example.top10.domen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.top10.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyTrackAdapter extends RecyclerView.Adapter<MyTrackAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Tracks> mTracks;

    public MyTrackAdapter(Context context, ArrayList<Tracks> tracks) {
        mContext = context;
        mTracks = tracks;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.track_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tracks currentTrack = mTracks.get(position);

        int pos = currentTrack.getPosition();
        String imageURL = currentTrack.getImageURL();
        String title = currentTrack.getTitle();
        String name = currentTrack.getArtistName();
        String link = currentTrack.getLink();

        holder.tvPosition.setText(""+pos);

        Picasso.get().load(imageURL).fit().centerInside().into(holder.imgView);

        holder.tvTitle.setText(title);
        holder.tvArtist.setText(name);
        holder.tvLink.setText(link);

    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tvPosition;
        public ImageView imgView;
        public TextView tvTitle;
        public TextView tvArtist;
        public TextView tvLink;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPosition = itemView.findViewById(R.id.position);
            imgView = itemView.findViewById(R.id.imgView);
            tvTitle = itemView.findViewById(R.id.title);
            tvArtist = itemView.findViewById(R.id.name);
            tvLink = itemView.findViewById(R.id.link);
        }
    }

}
