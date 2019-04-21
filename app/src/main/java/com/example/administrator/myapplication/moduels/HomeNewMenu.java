package com.example.administrator.myapplication.moduels;

/**
 * Created by Administrator on 2018/4/28.
 */

public class HomeNewMenu {
    private String title;
    private String time;
    private int image;
    private String read;
    private Class url;
    public HomeNewMenu(int image,String title,String time,String read,Class url){
        this.image=image;
        this.title=title;
        this.time=time;
        this.read=read;
        this.url=url;
    }
    public int getImage(){
        return  image;
    }

    public void setImage(int image){
        this.image=image;
    }

    public String getTitle(){return title;}

    public void setTitle(String title){
        this.title=title;
    }

    public String  getRead(){return read;}

    public void setRead(String read){
        this.read=read;
    }

    public String getTime(){return time;}

    public void setTime(String time){this.time=time;}

    public Class getUrl() {
        return url;
    }

    public void setUrl(Class url) {
        this.url = url;
    }
}
