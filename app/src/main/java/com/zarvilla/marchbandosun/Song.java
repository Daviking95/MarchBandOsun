package com.zarvilla.marchbandosun;

import java.io.Serializable;

/**
 * Created by lenovo on 6/17/2017.
 */

public class Song implements Serializable{
    private String name;
    private String no;
    private String tagger;

    public Song(String name, String no, String tagger) {
        this.name = name;
        this.no = no;
        this.tagger = tagger;
    }

    public String getName() {
        return name;
    }

    public String getNo() {
        return no;
    }

    public String getTagger() {
        return tagger;
    }
}