package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

public class MyDataCompany extends AppCompatActivity {
    private TextView tv_company_ok;
    private EditText et_company;
    private ImageView mydata_back_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data_company);
        et_company=(EditText)findViewById(R.id.et_company);

        mydata_back_bt=(ImageView)findViewById(R.id.mydata_back_bt);
        mydata_back_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_company_ok=(TextView)findViewById(R.id.tv_company_ok);
        tv_company_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String company_name=et_company.getText().toString();
                Intent intent=getIntent();
                intent.putExtra("newcompany",company_name);
                setResult(6,intent);
                finish();

            }
        });
    }
}
