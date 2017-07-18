package com.zarvilla.marchbandosun.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zarvilla.marchbandosun.R;
import com.zarvilla.marchbandosun.Song;

import java.util.ArrayList;

/**
 * Created by lenovo on 6/17/2017.
 */

public class snareAdapter extends RecyclerView.Adapter<snareAdapter.SongsViewHolder>{
    ArrayList<Song> songs = new ArrayList<Song>();
    Context ctx;

    public snareAdapter(ArrayList<Song> songs, Context ctx) {
        this.songs = songs;
        this.ctx = ctx;
    }

    @Override
    public SongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row,parent, false);
        return new SongsViewHolder(v, ctx, songs);
    }

    @Override
    public void onBindViewHolder(snareAdapter.SongsViewHolder holder, int position) {
        final Song s = songs.get(position);
        holder.songText.setText(s.getName());
        holder.noText.setText(s.getNo());
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public static class SongsViewHolder extends RecyclerView.ViewHolder {
        public TextView songText;
        public TextView noText;
        ArrayList<Song> songs = new ArrayList<Song>();
        Context ctx;

        public SongsViewHolder(View view, Context ctx, ArrayList<Song> songs) {
            super(view);
            this.songs = songs;
            this.ctx = ctx;
            // view.setOnClickListener(this);
            songText = (TextView) view.findViewById(R.id.name);
            noText = (TextView) view.findViewById(R.id.no);
        }

    }
}