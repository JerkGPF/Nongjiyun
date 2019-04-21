package com.example.administrator.myapplication.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.example.administrator.myapplication.R;

public class Knowledge_Menu_Animal_CattleActivity extends AppCompatActivity {
    private Button button;
    private RadioButton rb;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge__menu__animal__cattle);

        button=findViewById(R.id.knowledge_menu_animal_cattle_bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rb=findViewById(R.id.knowledge_menu_animal_cattle_rb);
        rb.setText("暂无内容");
        rb.setButtonDrawable(null);
        rb.setTextColor(Color.GRAY);
        rb.setGravity(Gravity.CENTER);


        relativeLayout=findViewById(R.id.cattle_refreshLayout);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onResume();
            }
        });



    }
}
