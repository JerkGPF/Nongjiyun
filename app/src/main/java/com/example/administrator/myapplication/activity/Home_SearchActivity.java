package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

public class Home_SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView home_search_rice;
    private ImageView edit_search_back;
    private TextView caomei;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__search);
        init();

    }

    private void init() {
        edit_search_back=(ImageView)findViewById(R.id.home_edit_search_back);
        home_search_rice=(TextView)findViewById(R.id.home_search_rice);
        caomei =(TextView)findViewById(R.id.caomei);
        caomei.setOnClickListener(this);
        edit_search_back.setOnClickListener(this);
        home_search_rice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_edit_search_back:
                finish();
                break;
            case R.id.home_search_rice:
                Intent intent=new Intent(Home_SearchActivity.this, Home_Search_DetailActivity.class);
                intent.putExtra("view","稻");
                startActivity(intent);
                break;
            case R.id.caomei:
                Intent intent1=new Intent(Home_SearchActivity.this,Home_Search_DetailActivity.class);
                intent1.putExtra("view","草莓");
                startActivity(intent1);
                break;
        }
    }
}
