package com.zarvilla.marchbandosun.frags;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.zarvilla.marchbandosun.R;

import java.util.ArrayList;

import com.zarvilla.marchbandosun.SongDetailsActivity;
import com.zarvilla.marchbandosun.Song;
import com.zarvilla.marchbandosun.adapters.snareAdapter;

public class snareFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Song> songList = new ArrayList<Song>();

    String[] songName, songNo, songTag, snareSounds;

    //Add a resource of music files in Array

    final int[] resID = {R.raw.babe, R.raw.africa};

    public snareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.tenor, container, false);
        View view = inflater.inflate(R.layout.tenor, container, false);
        recyclerView =  (RecyclerView) view.findViewById(R.id.recyclingView_tenor);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        setUpListeners();

        songName = getResources().getStringArray(R.array.song_name);
        snareSounds = getResources().getStringArray(R.array.snare_sounds);
        songNo = getResources().getStringArray(R.array.song_no);
        songTag = getResources().getStringArray(R.array.song_tag);

        int count = 0;
        for (String Name: songName){
            Song song = new Song(songName[count], songNo[count], songTag[count]);
            count++;
            songList.add(song);
        }

        adapter = new snareAdapter(songList, this.getActivity());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void setUpListeners(){
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Song song = songList.get(position);
                Log.i("TAG", "Song No: " + song.getNo());

                Intent intent =  new Intent(getActivity(), SongDetailsActivity.class);
                intent.putExtra("song", song);

                startActivity(intent);


            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}
