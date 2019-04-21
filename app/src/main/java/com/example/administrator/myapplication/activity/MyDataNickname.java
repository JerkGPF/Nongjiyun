package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

public class MyDataNickname extends AppCompatActivity implements View.OnClickListener{
    private EditText et_newname;
    private TextView tv_ok;
    private ImageView mydata_back_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data_nickname);
        et_newname=(EditText)findViewById(R.id.et_newname);
        mydata_back_bt=(ImageView)findViewById(R.id.mydata_back_bt);
        mydata_back_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_ok=(TextView)findViewById(R.id.tv_ok);
        tv_ok.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String newname=et_newname.getText().toString();
        Intent intent=getIntent();
        intent.putExtra("newname",newname);
        setResult(4,intent);
        finish();
    }
}
