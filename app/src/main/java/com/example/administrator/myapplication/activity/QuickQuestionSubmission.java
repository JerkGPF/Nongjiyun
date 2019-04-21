package com.example.administrator.myapplication.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.utils.LocationUtil;

import java.io.IOException;

import static com.mob.MobSDK.getContext;

public class QuickQuestionSubmission extends AppCompatActivity {

    private ImageView agricultural_expert_back_iv;
    private TextView tv_receive;
    private LinearLayout ly_question_choose;
    private TextView push_address;
    private String str_location;
    private static final int REQUEST_PERMISSION_LOCATION = 255;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_quick_question_submission);
        agricultural_expert_back_iv = (ImageView) findViewById(R.id.agricultural_expert_back_iv);
        agricultural_expert_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initView();
        initOnclick();
        push_address = (TextView)findViewById(R.id.push_address);
        push_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_PERMISSION_LOCATION);
                }
                LocationUtil.initLocation(getApplicationContext());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            str_location= LocationUtil.getAddress(LocationUtil.location,getApplicationContext());
                            //位置信息-----一个字符串
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 100:
                String liangjing=data.getStringExtra("liangjing");
                tv_receive.setText(liangjing);
                break;
            case 200:
                String yuanyi=data.getStringExtra("yuanyi");
                tv_receive.setText(yuanyi);
                break;
            case 300:
                String chumu=data.getStringExtra("chumu");
                tv_receive.setText(chumu);
                break;
            case 400:
                String shuichan=data.getStringExtra("shuichan");
                tv_receive.setText(shuichan);
                break;
            case 500:
                String nongji=data.getStringExtra("nongji");
                tv_receive.setText(nongji);
                break;
            case 600:
                String qita=data.getStringExtra("qita");
                tv_receive.setText(qita);
                break;

        }
    }

    private void initView() {
        tv_receive = (TextView) findViewById(R.id.tv_receive);
        ly_question_choose = (LinearLayout) findViewById(R.id.ly_question_choose);
    }
    private void initOnclick() {
        ly_question_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(QuickQuestionSubmission.this,QuickQuestionChooseType.class);
//                startActivityForResult(intent,1);
            }
        });
    }
}
