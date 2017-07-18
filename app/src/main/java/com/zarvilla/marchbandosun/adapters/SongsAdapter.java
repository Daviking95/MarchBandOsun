package com.zarvilla.marchbandosun.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zarvilla.marchbandosun.R;
import com.zarvilla.marchbandosun.Song;

import java.util.List;

/**
 * Created by lenovo on 6/17/2017.
 */

public class SongsAdapter extends
        RecyclerView.Adapter<SongsAdapter.MyViewHolder> {

    private List<Song> songList;

    public SongsAdapter(List<Song> songList, Context context) {
        this.songList = songList;
        this.context = context;
    }

    private Context context;

    /**
     * View holder class
     * */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView songText;
        public TextView noText;
        public LinearLayout linearLayout;

        public MyViewHolder(View view) {
            super(view);
            songText = (TextView) view.findViewById(R.id.name);
            noText = (TextView) view.findViewById(R.id.no);
            linearLayout = (LinearLayout) view.findViewById(R.id.listLinear);
        }
    }

    public SongsAdapter(List<Song> songList) {
        this.songList = songList;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Song c = songList.get(position);
//        holder.songText.setText(c.name);
//        holder.noText.setText(c.no);

//        songList.get(position);
        holder.songText.setText(c.getName());
        holder.noText.setText(c.getNo());

//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, "You clicked " + c.getName(), Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row,parent, false);
        return new MyViewHolder(v);
    }
}
