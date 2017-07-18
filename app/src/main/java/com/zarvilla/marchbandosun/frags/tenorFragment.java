package com.zarvilla.marchbandosun.frags;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zarvilla.marchbandosun.R;
import com.zarvilla.marchbandosun.Song;
import com.zarvilla.marchbandosun.adapters.mainAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class tenorFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Song> songList = new ArrayList<Song>();

    String[] songName, songNo, songTag;

    public tenorFragment() {
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

        songName = getResources().getStringArray(R.array.song_name);
        songNo = getResources().getStringArray(R.array.song_no);
        songTag = getResources().getStringArray(R.array.song_tag);

        int count = 0;
        for (String Name: songName){
            Song song = new Song(songName[count], songNo[count], songTag[count]);
            count++;
            songList.add(song);
        }
        adapter = new mainAdapter(songList, this.getActivity());
        recyclerView.setAdapter(adapter);
        return view;
    }

}
