package com.example.administrator.myapplication.moduels;

public class Knowledge_Menu_Tec {
    private String title;
    private String date;
    private String readnum;
    private Class aClass;
    public Knowledge_Menu_Tec(String title, String date, String readnum, Class aClass){
        this.title=title;
        this.date=date;
        this.readnum=readnum;
        this.aClass=aClass;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public String getReadnum() {
        return readnum;
    }

    public void setReadnum(String readnum) {
        this.readnum = readnum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
