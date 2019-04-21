package com.example.administrator.myapplication.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.utils.DataCleanManager;

public class My_SettingActivity extends AppCompatActivity {
    private RelativeLayout hotline;
    private RelativeLayout cace;
    private TextView cace_tv;
    private RelativeLayout about_tv;
    private Button exit_bt;

    private ImageView back_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__setting);
        exit_bt =(Button)findViewById(R.id.set_exit);
        back_iv =(ImageView)findViewById(R.id.set_back_bt);
        back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cace_tv =(TextView)findViewById(R.id.set_cace_tv);
        about_tv =(RelativeLayout)findViewById(R.id.set_about) ;
        about_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(My_SettingActivity.this,Setting_AboutActivity.class);
                startActivity(intent);
            }
        });

        initHotLine();//客服热线
        CaceMuch();//显示缓存大小

        initCace();//清空缓存
        initExit();//退出登录


    }

    private void initExit() {//退出登录
        exit_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=getSharedPreferences("admin",Context.MODE_PRIVATE).edit();
                editor.clear();
                editor.apply();
                finish();
            }
        });
    }

    private void CaceMuch() {
        try {
        cace_tv.setText(DataCleanManager.getTotalCacheSize(cace_tv.getContext()));
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    private void initCace() {
        cace =(RelativeLayout)findViewById(R.id.set_cace);
        cace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogCace();
            }

            private void DialogCace() {
                String yes = "<font color='#2EC667'>" + "确定" + "</font>";
                String no = "<font color='#2EC667'>" + "取消" + "</font>";
                AlertDialog dialog = new AlertDialog.Builder(My_SettingActivity.this)
                        .setMessage("是否清空缓存")//设置对话框的内容
                        //设置对话框的按钮
                        .setNegativeButton(Html.fromHtml(no), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton(Html.fromHtml(yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DataCleanManager.clearAllCache(cace.getContext());//清空缓存
                                dialog.dismiss();
                                CaceMuch(); }//重新计算缓存
                        }).create();

                dialog.show();

            }

        });

    }


    private void initHotLine() {
        hotline = (RelativeLayout) findViewById(R.id.set_hotline);
        hotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogHotline();
            }

            private void DialogHotline() {
                String yes = "<font color='#2EC667'>" + "是" + "</font>";
                String no = "<font color='#2EC667'>" + "否" + "</font>";
                AlertDialog dialog = new AlertDialog.Builder(My_SettingActivity.this)
                        .setMessage("是否拨打电话")//设置对话框的内容
                        //设置对话框的按钮
                        .setNegativeButton(Html.fromHtml(no), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton(Html.fromHtml(yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                call("025-86261287");
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
            }

        });
    }
    /**
     * 调用拨号界面
     *
     * @param phone 电话号码
     */
    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}


