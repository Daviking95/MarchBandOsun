package com.zarvilla.marchbandosun.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zarvilla.marchbandosun.BandInstrumentClass;
import com.zarvilla.marchbandosun.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 6/17/2017.
 */

public class BandInstrumentAdapter extends RecyclerView.Adapter<BandInstrumentAdapter.BandViewHolder>{
    ArrayList<BandInstrumentClass> band = new ArrayList<BandInstrumentClass>();
//    Context ctx;

    public BandInstrumentAdapter(ArrayList<BandInstrumentClass> band) {
        this.band = band;
//        this.ctx = ctx;
    }

    @Override
    public BandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.band_instrument_layout,parent, false);
        BandViewHolder bandViewHolder = new BandViewHolder(v);
        return bandViewHolder;
    }

    @Override
    public void onBindViewHolder(BandViewHolder holder, int position) {
        final BandInstrumentClass b = band.get(position);
        holder.band_img.setImageResource(b.getImg_id());
        holder.bandText.setText(b.getBand_text());
    }

    @Override
    public int getItemCount() {
        return band.size();
    }

    public static class BandViewHolder extends RecyclerView.ViewHolder { //        implements View.OnClickListener
        ImageView band_img;
        public TextView bandText;
        ArrayList<BandInstrumentClass> band = new ArrayList<BandInstrumentClass>();
        //        Context ctx;
        public BandViewHolder(View view){
            super(view);
//            this.band = band;
//            this.ctx = ctx;
//            view.setOnClickListener(this);
            band_img = (ImageView) view.findViewById(R.id.band_image);
            bandText = (TextView) view.findViewById(R.id.band_text);
        }

//        @Override
//        public void onClick(View view) {
//            int position = getAdapterPosition();
//            BandInstrumentClass band = this.band.get(position);
//
//
//            Intent intent =  new Intent(this.ctx, SongDetailsActivity.class);
////            intent.putExtra("img_id", contact)
//            intent.putExtra("name", songs.getName());
//            intent.putExtra("no", songs.getNo());
//            intent.putExtra("tag", songs.getTagger());
//
//            this.ctx.startActivity(intent);
//        }
    }
}
