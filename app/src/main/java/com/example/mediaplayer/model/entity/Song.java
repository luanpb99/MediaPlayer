package com.example.mediaplayer.model.entity;

import java.io.Serializable;

public class Song implements Serializable {

    private int id;
    private String code;
    private String name;
    private String singer;
    private String uriSong;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getUriSong() {
        return uriSong;
    }


}
