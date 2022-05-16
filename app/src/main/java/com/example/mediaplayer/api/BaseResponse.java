package com.example.mediaplayer.api;

public class BaseResponse {
    private String code;
    private int page;
    private int size;
    private int total;

    public String getCode() {
        return code;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public int getTotal() {
        return total;
    }
}
