package com.example.administrator.myapplication.moduels;

public class Knowledge {
    private int img;
    private String name;
    private Class aClass;

    public Knowledge(int img, String name, Class aClass){
        this.img=img;
        this.name=name;
        this.aClass=aClass;
    }
    public int getImg(){
        return  img;
    }

    public void setImg(int img){
        this.img=img;
    }
    public String getName(){return name;}

    public void setName(String name){
        this.name=name;
    }
    public Class getaClass(){return aClass;}

    public void setaClass(Class aClass){
        this.aClass=aClass;
    }
}