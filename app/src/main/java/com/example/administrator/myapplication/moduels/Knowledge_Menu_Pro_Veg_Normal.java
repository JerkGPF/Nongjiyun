package com.example.administrator.myapplication.moduels;

public class Knowledge_Menu_Pro_Veg_Normal {
    private int img;
    private String name;
    private String sum;
    private String main;
    private String inn;
    private Class aClass;

    public Knowledge_Menu_Pro_Veg_Normal(int img, String name, String sum, String main, String inn, Class aClass){
        this.img=img;
        this.name=name;
        this.sum=sum;
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

