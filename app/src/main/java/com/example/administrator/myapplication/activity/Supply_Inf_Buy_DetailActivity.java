package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;

public class Supply_Inf_Buy_DetailActivity extends AppCompatActivity {
    private ImageView sell_detail_back_iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supply__inf__buy__detail);
        sell_detail_back_iv=(ImageView)findViewById(R.id.sell_detail_back_iv);
        sell_detail_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
