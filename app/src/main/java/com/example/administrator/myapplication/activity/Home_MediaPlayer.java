package com.example.administrator.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.myapplication.R;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class Home_MediaPlayer extends AppCompatActivity {

private JZVideoPlayerStandard jzVideoPlayerStandard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__media_player);

//设置视频地址、缩略图地址、标题
        jzVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
        JZVideoPlayerStandard jzVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
        jzVideoPlayerStandard.setUp
                ("http://object.jsnjy.net.cn/OSS/20180427/132.mp4"
                        , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "球根花卉种植");
    }

@Override
public void onBackPressed() {
    if (JZVideoPlayer.backPress()) {
        return;
    }
    super.onBackPressed();
}
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
    }

