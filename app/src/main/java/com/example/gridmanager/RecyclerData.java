package com.example.gridmanager;

public class RecyclerData {

    private String title;
    private int imgid;
    private int span;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSpan() {
        return span;
    }

    public void setSpan(int span) {
        this.span = span;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public RecyclerData(String title, int imgid, int span) {
        this.title = title;
        this.imgid = imgid;
        this.span = span;
    }
}
