package com.zarvilla.marchbandosun.frags;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zarvilla.marchbandosun.BandAnthemActivity;
import com.zarvilla.marchbandosun.CodeOfConductActivity;
import com.zarvilla.marchbandosun.HomeActivity;
import com.zarvilla.marchbandosun.ParadeCommandsActivity;
import com.zarvilla.marchbandosun.R;
import com.zarvilla.marchbandosun.TheOfficialsActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    ProgressBar myprogressBar;
    LinearLayout l1, l2, l3, l4, l7, l8;

    private OnFragmentClickListener mListener;

    int i = 0;

    public interface OnFragmentClickListener{
        void onFragmentClicked(Fragment selectedFragment);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentClickListener){
            mListener = (OnFragmentClickListener) context;
        } else{
            throw new IllegalArgumentException("Activity must implement OnFragmentListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_dashboard, container, false);

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        myprogressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        l1 = (LinearLayout) view.findViewById(R.id.linear_1);
        l2 = (LinearLayout) view.findViewById(R.id.linear_2);
        l3 = (LinearLayout) view.findViewById(R.id.linear_3);
        l4 = (LinearLayout) view.findViewById(R.id.linear_4);
        l7 = (LinearLayout) view.findViewById(R.id.linear_7);
        l8 = (LinearLayout) view.findViewById(R.id.linear_8);

        l1.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                setFragment(new dataFragment());
                mListener.onFragmentClicked(new dataFragment());
//                Snackbar.make(v, "List One", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        l2.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                setFragment(new dataFragment());
                Intent bandAnt = new Intent(getActivity(), BandAnthemActivity.class);
                startActivity(bandAnt);
            }
        });

        l3.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                setFragment(new dataFragment());
                Intent bandAnt = new Intent(getActivity(), TheOfficialsActivity.class);
                startActivity(bandAnt);
            }
        });

        l4.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                setFragment(new dataFragment());
                Intent bandAnt = new Intent(getActivity(), CodeOfConductActivity.class);
                startActivity(bandAnt);
            }
        });

        l7.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                setFragment(new dataFragment());
                Intent bandAnt = new Intent(getActivity(), ParadeCommandsActivity.class);
                startActivity(bandAnt);
            }
        });

        l8.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                setFragment(new dataFragment());
                mListener.onFragmentClicked(new VideoFragment());
            }
        });


        return view;
    }

}
