package com.example.administrator.myapplication.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;

public class HomeEditSearch extends AppCompatActivity implements View.OnClickListener{
    private ImageView edit_search_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__edit__search);
        initDate();
        init();
    }



    private void initDate() {
        edit_search_back=(ImageView)findViewById(R.id.home_edit_search_back);
        edit_search_back.setOnClickListener(this);
    }

    private void init() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_edit_search_back:
                Intent intent=new Intent(HomeEditSearch.this,HomeFragment.class);

                startActivity(intent);
        }

    }
}
