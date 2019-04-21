package com.example.administrator.myapplication.moduels;

/**
 * Created by Administrator on 2018/5/4.
 */

public class Home_technology_gridview_rice_menu {
    private String title;
    private String date;
    private  String reader;
    private int image;
    private Class url;
    private String neturl;
    public Home_technology_gridview_rice_menu(int image, String title, String date, String reader, Class url,String  neturl){
        this.image=image;
        this.title=title;
        this.date=date;
        this.reader=reader;
        this.url=url;
        this.neturl=neturl;
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

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Class getUrl() {
        return url;
    }

    public void setUrl(Class url) {
        this.url = url;
    }

    public String getNeturl() {
        return neturl;
    }

    public void setNeturl(String neturl) {
        this.neturl = neturl;
    }
}
