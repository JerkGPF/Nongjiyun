package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.fragment.Home_Details;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class MyShareActivity extends AppCompatActivity {
    private ImageView back_iv;
    private RadioButton rb_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_share);

        back_iv = (ImageView) findViewById(R.id.myshare_back_iv);
        back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rb_share = (RadioButton) findViewById(R.id.myshare_btn);
        rb_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnekeyShare oks = new OnekeyShare();
                oks.setImageUrl("");
                oks.setText("text");
                oks.setTitle("title");
                oks.setCallback(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Log.i("ssss", "onComplete");
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {
                        Log.i("ssss", "onError" + throwable);
                    }

                    @Override
                    public void onCancel(Platform platform, int i) {
                        Log.i("ssss", "onCancel");
                    }
                });
                oks.show(MyShareActivity.this);
            }
        });
    }
}
