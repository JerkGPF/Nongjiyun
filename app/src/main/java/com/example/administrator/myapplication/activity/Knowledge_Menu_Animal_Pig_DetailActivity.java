package com.example.administrator.myapplication.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.administrator.myapplication.R;

public class Knowledge_Menu_Animal_Pig_DetailActivity extends AppCompatActivity {
    private Button button;
    private RadioButton rb;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge__menu__animal__pig__detail);

        button = findViewById(R.id.knowledge_menu_animal_pig_detail_bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rb = findViewById(R.id.knowledge_menu_animal_pig_detail_collection);
        rb.setText("收藏");
        rb.setButtonDrawable(null);
        rb.setTextColor(Color.WHITE);
        rb.setGravity(Gravity.CENTER);
        radioButton = findViewById(R.id.knowledge_menu_animal_pig_detail_share);
        radioButton.setText("分享");
        radioButton.setButtonDrawable(null);
        radioButton.setTextColor(Color.WHITE);
        radioButton.setGravity(Gravity.CENTER);



        WebView browser=(WebView)findViewById(R.id.pig_detail);
        browser.loadUrl("http://njy.jsnjy.net.cn/web/share/new.action?newId=ee67e65d-d498-485c-9e98-eced9c009c69");

        //设置可自由缩放网页
        browser.getSettings().setSupportZoom(true);
        browser.getSettings().setBuiltInZoomControls(true);

        // 如果页面中链接，如果希望点击链接继续在当前browser中响应，
        // 而不是新开Android的系统browser中响应该链接，必须覆盖webview的WebViewClient对象
        browser.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });
    }
}
