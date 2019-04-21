package com.example.administrator.myapplication.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.Activity_login;
import com.mob.MobSDK;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;

import static cn.sharesdk.sina.weibo.SinaWeibo.*;

public class Home_Details extends AppCompatActivity implements View.OnClickListener{
    private RadioButton details_iv1;
    private RadioButton details_iv2;
    private WebView webView;
    private WebSettings webSettings;
    private ImageView agricultural_expert_back_iv;

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__details);
        agricultural_expert_back_iv=(ImageView)findViewById(R.id.agricultural_expert_back_iv);
        agricultural_expert_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        MobSDK.init(this);

        details_iv1 = (RadioButton) findViewById(R.id.home_notice_system_collection1);
        details_iv2 = (RadioButton) findViewById(R.id.home_notice_system_share1);
        webView=(WebView)findViewById(R.id.webView);
        details_iv1.setOnClickListener(this);
        details_iv2.setOnClickListener(this);


        //取得从上一个Activity当中传递过来的Intent对象
        Intent intent = getIntent();
        //从Intent当中根据key取得value
        String value = intent.getStringExtra("view");
        //根据控件的ID得到响应的控件对象
         webView.loadUrl(value);






        /**
         * 微信分享给好友 点击事件
         */
    }
        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.home_notice_system_collection1:
                    Intent intent = new Intent(Home_Details.this, Activity_login.class);
                    startActivity(intent);
                    break;
                case R.id.home_notice_system_share1:

                    OnekeyShare oks = new OnekeyShare();
                    Platform platform = ShareSDK.getPlatform(QQ.NAME);
                    platform.setPlatformActionListener(new PlatformActionListener() {

                        @Override
                        public void onComplete(Platform platform, int i, HashMap<String, Object> stringObjectHashMap) {
                            //授权成功，并返回授权信息，在stringObjectHashMap中，打印出stringObjectHashMap，会发现你要的信息

                        }

                        @Override
                        public void onError(Platform platform, int i, Throwable throwable) {
                            //授权中出现异常
                        }

                        @Override
                        public void onCancel(Platform platform, int i) {
                            //用户取消了授权
                        }
                    });
                    platform.SSOSetting(false);   //优先使用客户端登陆，为true时使用网页登陆
                    platform.showUser(null);   //为null表示使用当前账户登陆
//                    Platform qq = ShareSDK.getPlatform(QQ.NAME);
//                    qq.SSOSetting(false);  //设置false表示使用SSO授权方式
//                    qq.setPlatformActionListener((PlatformActionListener) this); // 设置分享事件回调
//                    qq.authorize();
                    //关闭sso授权
                  //  oks.disableSSOWhenAuthorize();
                    // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
                    oks.setTitle("标题");
                    // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
                    oks.setTitleUrl("http://sharesdk.cn");
                    // text是分享文本，所有平台都需要这个字段
                    oks.setText("我是分享文本");
                    //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
                    oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
                    // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                    //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                    // url仅在微信（包括好友和朋友圈）中使用
                    oks.setUrl("http://sharesdk.cn");
                    // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                    oks.setComment("我是测试评论文本");
                    // site是分享此内容的网站名称，仅在QQ空间使用
                    oks.setSite("ShareSDK");
                    // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                    oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
                    oks.show(this);
                    break;
                }

//
//                    OnekeyShare oks = new OnekeyShare();
//                    oks.setImageUrl("");
//                    oks.setText("text");
//                    oks.setTitle("title");
//                    oks.setCallback(new PlatformActionListener() {
//                        @Override
//                        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
//                            Log.i("分享完成", "onComplete");
//                        }
//
//                        @Override
//                        public void onError(Platform platform, int i, Throwable throwable) {
//                            Log.i("错误", "onError" + throwable);
//                        }
//
//                        @Override
//                        public void onCancel(Platform platform, int i) {
//                            Log.i("", "onCancel");
//                        }
//                    });
//                    oks.show(Home_Details.this);

            }
        }
