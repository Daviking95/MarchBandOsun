package com.zarvilla.marchbandosun.frags;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zarvilla.marchbandosun.R;
import com.zarvilla.marchbandosun.adapters.nAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class bassFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String[] songName = {"Vien", "Good Days", "I am the best", "We are here"};
    String[] songNo = {"1", "2", "3", "4"};

    public bassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.bass, container, false);
        View view = inflater.inflate(R.layout.bass, container, false);
        recyclerView =  (RecyclerView) view.findViewById(R.id.recyclingView_bass);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter = new nAdapter(songName, songNo);
        recyclerView.setAdapter(adapter);
        return view;
    }

}
