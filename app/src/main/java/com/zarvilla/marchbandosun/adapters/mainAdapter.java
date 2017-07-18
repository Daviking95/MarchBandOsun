package com.zarvilla.marchbandosun.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zarvilla.marchbandosun.R;
import com.zarvilla.marchbandosun.Song;
import com.zarvilla.marchbandosun.SongDetailsActivity;

import java.util.ArrayList;

/**
 * Created by lenovo on 6/17/2017.
 */

public class mainAdapter extends RecyclerView.Adapter<mainAdapter.SongsViewHolder>{
    ArrayList<Song> songs = new ArrayList<Song>();
    Context ctx;

    public mainAdapter(ArrayList<Song> songs, Context ctx) {
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
    public void onBindViewHolder(SongsViewHolder holder, int position) {
        final Song s = songs.get(position);
        holder.songText.setText(s.getName());
        holder.noText.setText(s.getNo());
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public static class SongsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView songText;
        public TextView noText;
        ArrayList<Song> songs = new ArrayList<Song>();
        Context ctx;
        public SongsViewHolder(View view, Context ctx, ArrayList<Song> songs){
            super(view);
            this.songs = songs;
            this.ctx = ctx;
            view.setOnClickListener(this);
            songText = (TextView) view.findViewById(R.id.name);
            noText = (TextView) view.findViewById(R.id.no);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Song song = this.songs.get(position);

            Intent intent =  new Intent(this.ctx, SongDetailsActivity.class);
//            intent.putExtra("img_id", contact)
            intent.putExtra("name", song.getName());
            intent.putExtra("no", song.getNo());
            intent.putExtra("tag", song.getTagger());

            this.ctx.startActivity(intent);
        }
    }
}
