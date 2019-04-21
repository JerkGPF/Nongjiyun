package com.example.administrator.myapplication.moduels;

import android.service.quicksettings.Tile;

/**
 * Created by Administrator on 2018/5/12.
 */

public class HomeHeadLineMenu {
    private int image;
    private String title;
    private String date;
    private String ontop;
    private String reader;
    public HomeHeadLineMenu(int image,String title,String date,String ontop,String reader){
        this.image=image;
        this.title= title;
        this.date=date;
        this.ontop=ontop;
        this.reader=reader;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOntop() {
        return ontop;
    }

    public void setOntop(String ontop) {
        this.ontop = ontop;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }
}
