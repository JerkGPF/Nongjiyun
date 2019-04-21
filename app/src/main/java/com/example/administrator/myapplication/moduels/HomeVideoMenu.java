package com.example.administrator.myapplication.moduels;

/**
 * Created by Administrator on 2018/4/29.
 */

public class HomeVideoMenu {
    private int  iv_video;
    private String  tv_video;
    private Class  video_url;

    public HomeVideoMenu(int iv_video,String tv_video,Class video_url){
        this.iv_video=iv_video;
        this.tv_video=tv_video;
        this.video_url=video_url;

    }
    public void setIv_video(int iv_video){
        this.iv_video=iv_video;
    }
    public int getIv_video(){
        return iv_video;
    }

    public void setTv_video(String tv_video){
        this.tv_video=tv_video;
    }
    public String getTv_video(){
        return tv_video;
    }

    public Class getVideo_url(){
        return video_url;
    }

    public void setVideo_Url(Class video_url) {
        this.video_url = video_url;
    }
}
