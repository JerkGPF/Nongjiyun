package com.example.administrator.myapplication.moduels;

public class Supply_Information_Buy {
    private String title;
    private String article;
    private String tv;
    private String address;
    private String date;

    public Supply_Information_Buy(String title,String article,String tv,String address,String date){
        this.title=title;
        this.article=article;
        this.tv=tv;
        this.address=address;
        this.date=date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
