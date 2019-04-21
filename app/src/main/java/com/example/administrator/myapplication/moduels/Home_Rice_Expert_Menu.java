package com.example.administrator.myapplication.moduels;

/**
 * Created by Administrator on 2018/5/9.
 */

public class Home_Rice_Expert_Menu {
    private int image;
    private String name;
    private String company;
    private String question;
    private String expert;
    private String rice;
    private Class url;
    public Home_Rice_Expert_Menu(int image,String name,String company,String question,
                                 String expert,String rice,Class url){
        this.image=image;
        this.name=name;
        this.company=company;
        this.question=question;
        this.expert=expert;
        this.rice=rice;
        this.url=url;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public String getRice() {
        return rice;
    }

    public void setRice(String rice) {
        this.rice = rice;
    }

    public Class getUrl() {
        return url;
    }

    public void setUrl(Class url) {
        this.url = url;
    }
}
