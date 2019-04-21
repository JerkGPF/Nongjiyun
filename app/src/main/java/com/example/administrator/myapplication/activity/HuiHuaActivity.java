package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.utils.PopWindow;


public class HuiHuaActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView add;
    private ImageView agricultural_expert_back_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hui_hua);
        findViewById(R.id.huihua_add).setOnClickListener(this);
        findViewById(R.id.agricultural_expert_back_iv).setOnClickListener(this);

    }
    public void person(View view){//好友列表activity
        Intent intent= new Intent(HuiHuaActivity.this,FriendActivity .class);
        startActivity(intent);

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.huihua_add) {
            PopWindow popWindow = new PopWindow(this);
            popWindow.showPopupWindow(findViewById(R.id.huihua_add));
        }
        if (v.getId()==R.id.agricultural_expert_back_iv){
            finish();
        }
    }

    public void head(View view) {
        Intent intent=new Intent(HuiHuaActivity.this,Add_Friend_Activity.class);
        startActivity(intent);
    }
}
