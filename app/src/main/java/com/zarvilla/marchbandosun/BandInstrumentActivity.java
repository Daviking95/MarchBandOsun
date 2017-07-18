package com.zarvilla.marchbandosun;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.zarvilla.marchbandosun.adapters.BandInstrumentAdapter;

import java.util.ArrayList;

public class BandInstrumentActivity extends AppCompatActivity {

    private RecyclerView recyclerViewBand;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<BandInstrumentClass> bandInstList = new ArrayList<BandInstrumentClass>();

    int[] band_img = {R.drawable.africamap, R.drawable.binoculars, R.drawable.talking};

    String[] band_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_band_instrument);

        band_text = getResources().getStringArray(R.array.band_instrument);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        int count = 0;
        for (String BandText : band_text) {
            BandInstrumentClass band = new BandInstrumentClass(band_img[count], BandText);
            count++;
            bandInstList.add(band);
        }

        recyclerViewBand = (RecyclerView) findViewById(R.id.recycler_view_band);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewBand.setLayoutManager(layoutManager);
        recyclerViewBand.setHasFixedSize(true);
        adapter = new BandInstrumentAdapter(bandInstList);
        recyclerViewBand.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
