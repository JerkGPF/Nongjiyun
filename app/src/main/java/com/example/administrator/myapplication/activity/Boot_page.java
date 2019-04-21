package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.administrator.myapplication.R;

import java.util.Timer;
import java.util.TimerTask;

public class Boot_page extends AppCompatActivity {
    //定义定时器，定义定时器任务
    private final Timer timer=new Timer();
    private TimerTask task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //定义全屏参数
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        getWindow().setFlags(flag, flag);
        setContentView(R.layout.activity_boot_page);
//        if (getSupportActionBar() != null){
//            getSupportActionBar().hide();
//        }
        //初始化定时器任务
          task=new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(Boot_page.this, AdvertiseActivity.class);
                startActivity(intent);
                finish();
            }
        };
        //启动定时器
        timer.schedule(task,1500);
    }

}
