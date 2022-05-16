package com.example.mediaplayer.model.entity;

import java.io.Serializable;

public class Category implements Serializable {
    private int id;
    private String name;
    private String code;

    public String getName() {
        return name;
    }

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

    public void setName(String name) {
        this.name = name;
    }
}
