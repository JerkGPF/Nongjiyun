package com.example.administrator.myapplication.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;

public class Home_Edit_Search extends AppCompatActivity {
    private ImageView home_edit_search_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__edit__search);

        home_edit_search_back=(ImageView)findViewById(R.id.home_edit_search_back);
        home_edit_search_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
