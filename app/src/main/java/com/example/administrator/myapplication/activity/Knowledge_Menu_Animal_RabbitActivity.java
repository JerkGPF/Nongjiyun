package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.Knowledge_Menu_Animal_RabbitAdapter;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Animal_Rabbit;

import java.util.ArrayList;
import java.util.List;

public class Knowledge_Menu_Animal_RabbitActivity extends AppCompatActivity {
    private Button button;
    private List<Knowledge_Menu_Animal_Rabbit> list;
    private ListView listView;
    private Knowledge_Menu_Animal_RabbitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge__menu__animal__rabbit);


        initData();
        button=findViewById(R.id.knowledge_menu_animal_rab_bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void initData() {
        listView = (ListView) findViewById(R.id.knowledge_menu_animal_rab_lv);
        listView.setBackgroundColor(Color.WHITE);
        list = new ArrayList<Knowledge_Menu_Animal_Rabbit>();
        Knowledge_Menu_Animal_Rabbit h1 = new Knowledge_Menu_Animal_Rabbit(R.mipmap.ic_launcher, "苏系长毛兔", "2018-05-01", "阅读数：248", Knowledge_Menu_Animal_Pig_DetailActivity.class);
        Knowledge_Menu_Animal_Rabbit h2 = new Knowledge_Menu_Animal_Rabbit(R.mipmap.ic_launcher, "新西兰兔", "2017-03-30", "阅读数：4263", Knowledge_Menu_Animal_Pig_DetailActivity.class);


        list.add(h1);
        list.add(h2);
        adapter = new Knowledge_Menu_Animal_RabbitAdapter(list, getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), list.get(position).getaClass());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
            }
        });

    }
}