package com.zarvilla.marchbandosun.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zarvilla.marchbandosun.R;

/**
 * Created by lenovo on 6/17/2017.
 */

public class nAdapter extends
        RecyclerView.Adapter<nAdapter.MyViewHolder> {

    String[] song_name, song_no;
//    ArrayList<Contact> contacts = new ArrayList<>();

    public nAdapter(String[] song_name, String[] song_no) {
        this.song_name = song_name;
        this.song_no = song_no;
    }

    private Context context;

    /**
     * View holder class
     * */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView songText;
        public TextView noText;
        public LinearLayout linearLayout;
//        ArrayList<Contact> contacts = new ArrayList<Contact>();
        Context context;

        public MyViewHolder(View view) {
            super(view);
//            this.contacts = contacts;
            this.context = context;
//            view.setOnClickListener(this);
            songText = (TextView) view.findViewById(R.id.name);
            noText = (TextView) view.findViewById(R.id.no);
            linearLayout = (LinearLayout) view.findViewById(R.id.listLinear);
        }

//        @Override
//        public void onClick(View view) {
//            int position = getAdapterPosition();
////            Contact contact = this.contacts.get(position);
//
//            Intent intent =  new Intent(context, ContactDetails.class);
////            intent.putExtra("img_id", contact)
//            intent.putExtra("name", contact.getName());
//            intent.putExtra("no", contact.getNo());
//
//            this.context.startActivity(intent);
//        }
    }

//    public nAdapter(ArrayList<Contact> contacts) {
//        this.contacts = contacts;
//    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        final Contact c = contacts.get(position);
//        holder.songText.setText(c.getName());
//        holder.noText.setText(c.getNo());
        holder.songText.setText(song_name[position]);
        holder.noText.setText(song_no[position]);
    }

    @Override
    public int getItemCount() {
        return song_name.length;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row,parent, false);
        return new MyViewHolder(v);
    }
}