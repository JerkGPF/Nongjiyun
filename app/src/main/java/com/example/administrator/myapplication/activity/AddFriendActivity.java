package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.administrator.myapplication.MainActivity;
import com.example.administrator.myapplication.R;

public class AddFriendActivity extends AppCompatActivity {
    private RelativeLayout layout;
    private ImageView myshare_back_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        layout = (RelativeLayout)findViewById(R.id.friend_relat);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddFriendActivity.this, Add_Friend_Activity.class);
                startActivity(intent);
            }
        });

        myshare_back_iv=(ImageView)findViewById(R.id.myshare_back_iv);
        myshare_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
