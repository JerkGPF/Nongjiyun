package com.example.administrator.myapplication.moduels;

public class Home_Search_Expert {
    private int img;
    private String name;
    private String sum;
    private String que;
    private String main;
    private String inn;
    private Class aClass;
    public Home_Search_Expert(int img, String name, String que,String sum, String main, String inn, Class aClass){
        this.img=img;
        this.name=name;
        this.sum=sum;
        this.que=que;
        this.main=main;
        this.inn=inn;
        this.aClass=aClass;

    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }


}
