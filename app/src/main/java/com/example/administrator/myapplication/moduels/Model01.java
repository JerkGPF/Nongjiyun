package com.example.administrator.myapplication.moduels;

/**
 * Created by Administrator on 2018/4/28.
 */

public class Model01 {
    public String title;
    public Class url;

    public Model01(String title, Class url) {
        this.title = title;
        this.url = url;
    }
public String getTitle(){return title;}
public void setTitle(String title){
    this.title=title;
}
public Class getUrl(){return url;}
public void setUrl(Class url){
    this.url=url;
}
}
