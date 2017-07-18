package com.zarvilla.marchbandosun;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by lenovo on 6/16/2017.
 */

public class RecyclerHolder extends RecyclerView.ViewHolder {

    public TextView titleText;

    public RecyclerHolder(View itemView) {
        super(itemView);

        titleText = (TextView)itemView;
    }
}
