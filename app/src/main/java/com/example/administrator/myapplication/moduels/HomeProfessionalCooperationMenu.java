package com.example.administrator.myapplication.moduels;

/**
 * Created by Administrator on 2018/5/5.
 */

public class HomeProfessionalCooperationMenu {
    private String title;
    private String time;
    private int image;
    private String text;
    private String read;
    private Class url;
    private String neturl;
    private String txt;

    public  HomeProfessionalCooperationMenu(int image,String title,String text,String txt,String time,String read,Class url,String neturl){
        this.image=image;
        this.title=title;
        this.text=text;
        this.txt=txt;
        this.time=time;
        this.read=read;
        this.url=url;
        this.neturl=neturl;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public Class getUrl() {
        return url;
    }

    public void setUrl(Class url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNeturl() {
        return neturl;
    }

    public void setNeturl(String neturl) {
        this.neturl = neturl;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
