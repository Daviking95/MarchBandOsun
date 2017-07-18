package com.zarvilla.marchbandosun.adapters;

/**
 * Created by lenovo on 6/16/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zarvilla.marchbandosun.frags.bassFragment;
import com.zarvilla.marchbandosun.frags.snareFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                snareFragment tab1 = new snareFragment();
                return tab1;
            case 1:
                bassFragment tab2 = new bassFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}