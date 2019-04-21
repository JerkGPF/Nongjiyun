package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

public class Register_Person_ChooseActivity extends AppCompatActivity {
    private ImageView agricultural_expert_back_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__person__choose);
        agricultural_expert_back_iv=(ImageView)findViewById(R.id.agricultural_expert_back_iv);
        agricultural_expert_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView putong=(TextView)findViewById(R.id.putong);
        TextView nongji=(TextView)findViewById(R.id.nongji);
        TextView tv_expert=(TextView)findViewById(R.id.tv_expert);

        putong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();
                intent.putExtra("values","普通用户");
                setResult(1000,intent);
                finish();

            }
        });
        nongji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=getIntent();
                intent1.putExtra("nongji","农技人员");
                setResult(500,intent1);
                finish();
            }
        });
        tv_expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=getIntent();
                intent2.putExtra("tv_expert","专家");
                setResult(800,intent2);
                finish();
            }
        });
    }
}
