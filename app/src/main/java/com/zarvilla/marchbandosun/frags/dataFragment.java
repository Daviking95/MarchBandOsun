package com.zarvilla.marchbandosun.frags;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zarvilla.marchbandosun.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class dataFragment extends Fragment {


    View view;
    ViewPager viewPager;
    TabLayout tabLayout;
//    PagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_data, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
//        viewPager.setAdapter(new sliderAdapter(getChildFragmentManager()));
        tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return view;
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {


        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new snareFragment(), "Snare");
        adapter.addFragment(new bassFragment(), "Bass");
        adapter.addFragment(new tenorFragment(), "Tenor");
        adapter.addFragment(new brassFragment(), "Brass");
        adapter.addFragment(new allFragment(), "All");
        viewPager.setAdapter(adapter);



    }

    private class Adapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

//        final  String tabs[]={"Snare", "Bass","Tenor", "Brass", "All"};
//        public sliderAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            switch (position) {
//                case 0:
//                    snareFragment snare = new snareFragment();
//                    return snare;
//                case 1:
//                    bassFragment bass = new bassFragment();
//                    return bass;
//                case 2:
//                    tenorFragment tenor = new tenorFragment();
//                    return tenor;
//                case 3:
//                    brassFragment brass = new brassFragment();
//                    return brass;
//                case 4:
//                    allFragment allF = new allFragment();
//                    return allF;
//                default:
//                    return null;
//            }
////            return new contentFragment();
//        }
//
//        @Override
//        public int getCount() {
//            return 5;
//        }
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return tabs[position];
//        }
    }

}
