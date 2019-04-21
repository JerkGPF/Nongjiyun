package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

public class MyDateChooseType extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_choose1;
    private TextView tv_choose2;
    private TextView tv_choose3;
    private TextView tv_choose4;
    private TextView tv_choose5;
    private ImageView agricultural_expert_back_iv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_date_choose_type);
         tv_choose1=(TextView)findViewById(R.id.tv_choose1);
        tv_choose2=(TextView)findViewById(R.id.tv_choose2);
        tv_choose3=(TextView)findViewById(R.id.tv_choose3);
        tv_choose4=(TextView)findViewById(R.id.tv_choose4);
        tv_choose5=(TextView)findViewById(R.id.tv_choose5);
        agricultural_expert_back_iv=(ImageView)findViewById(R.id.agricultural_expert_back_iv);
        tv_choose1.setOnClickListener(this);
        tv_choose2.setOnClickListener(this);
        tv_choose4.setOnClickListener(this);
        agricultural_expert_back_iv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
     switch (v.getId()){
         case R.id.tv_choose1:
             Intent intent=getIntent();
             intent.putExtra("choose1","农技人员");
             setResult(2,intent);
             finish();
             break;
         case R.id.tv_choose2:
             Intent intent1=getIntent();
             intent1.putExtra("choose2","专家");
             setResult(520,intent1);
             finish();
             break;
         case R.id.tv_choose4:
             Intent intent4=getIntent();
             intent4.putExtra("choose2","普通用户");
             setResult(521,intent4);
             finish();
             break;
         case R.id.agricultural_expert_back_iv:
             finish();
             break;

     }
    }
}
