package com.example.administrator.myapplication.moduels;

/**
 * Created by Administrator on 2018/6/1.
 */

public class HomeScienceTechnologyHemu {
    private int image;
    private String content;
    private String time;
    private String reader;
    private Class url;
    private String neturl;
    public HomeScienceTechnologyHemu(int image,String content,String time,String reader,Class url,String neturl){
        this.image=image;
        this.content=content;
        this.time=time;
        this.reader=reader;
        this.url=url;
        this.neturl=neturl;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
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
