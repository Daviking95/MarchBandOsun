package com.zarvilla.marchbandosun;

/**
 * Created by lenovo on 6/17/2017.
 */

public class BandInstrumentClass {
    private int img_id;
    private String band_text;

    public BandInstrumentClass(int img_id, String band_text) {
        this.setImg_id(img_id);
        this.band_text = band_text;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id){
        this.img_id = img_id;
    }

    public String getBand_text() {
        return band_text;
    }
}