package com.example.administrator.myapplication.moduels;

import android.net.Network;

/**
 * Created by Administrator on 2018/4/30.
 */

public class HomeNoticeMenu {
    private String notice_title;
    private String notice_time;
    private int notice_image;
    private String notice_content;
    private Class notice_url;
    private String neturl;
    public HomeNoticeMenu(int notice_image,String notice_title,String notice_time,String notice_content, Class notice_url,String neturl){
        this.notice_image=notice_image;
        this.notice_title=notice_title;
        this.notice_content=notice_content;
        this.notice_time=notice_time;
        this.notice_url=notice_url;
        this.neturl=neturl;

    }
    public int getNotice_image(){
        return  notice_image;
    }

    public void setNotice_image(int notice_image){
        this.notice_image=notice_image;
    }

    public String getNotice_title(){return notice_title;}

    public void setNotice_Title(String notice_title){
        this.notice_title=notice_title;
    }



    public String  getNotice_time(){return notice_time;}

    public void setNotice_time(String notice_time){
        this.notice_time=notice_time;
    }
    public String getNotice_content(){return notice_content;}

    public void setNotice_content(String notice_content){this.notice_content=notice_content;}
    public Class getNotice_url(){return notice_url;}
    public void setNotice_url(Class notice_url){
        this.notice_url=notice_url;
    }


    public String getNeturl() {
        return neturl;
    }

    public void setNeturl(String neturl) {
        this.neturl = neturl;
    }
}

