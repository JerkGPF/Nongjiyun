package com.example.administrator.myapplication.moduels;

/**
 * Created by Administrator on 2018/4/27.
 */

public class HomeMenu {
    private int image;
    private String name;
    private Class url;
  public HomeMenu(int image,String name,Class url){
      this.image=image;
      this.name=name;
      this.url=url;
  }
  public int getImage(){
         return  image;
  }

  public void setImage(int image){
      this.image=image;
  }
  public String getName(){return name;}

  public void setName(String name){
      this.name=name;
  }
  public Class getUrl(){return url;}

  public void setUrl(Class url){
      this.url=url;
  }
}
