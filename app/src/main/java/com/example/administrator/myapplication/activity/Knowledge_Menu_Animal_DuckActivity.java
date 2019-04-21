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
import com.example.administrator.myapplication.adapter.Knowledge_Menu_Animal_DuckAdapter;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Animal_Duck;

import java.util.ArrayList;
import java.util.List;

public class Knowledge_Menu_Animal_DuckActivity extends AppCompatActivity {
    private Button button;
    private List<Knowledge_Menu_Animal_Duck> list;
    private ListView listView;
    private Knowledge_Menu_Animal_DuckAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge__menu__animal__duck);
        initData();
        button = findViewById(R.id.knowledge_menu_animal_duck_bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        listView = (ListView) findViewById(R.id.knowledge_menu_animal_duck_lv);
        listView.setBackgroundColor(Color.WHITE);
        list = new ArrayList<Knowledge_Menu_Animal_Duck>();
        Knowledge_Menu_Animal_Duck h1 = new Knowledge_Menu_Animal_Duck(R.mipmap.ic_launcher, "黑羽番鸭", "2018-05-01", "阅读数：248", Knowledge_Menu_Animal_Pig_DetailActivity.class);
        Knowledge_Menu_Animal_Duck h2 = new Knowledge_Menu_Animal_Duck(R.mipmap.ic_launcher, "应用分子辅助技术选育的苏邮2号肉用麻鸭新品系（母系）", "2017-03-30", "阅读数：4263", Knowledge_Menu_Animal_Pig_DetailActivity.class);
        Knowledge_Menu_Animal_Duck h3 = new Knowledge_Menu_Animal_Duck(R.mipmap.ic_launcher, "京红1号蛋鸡", "2018-05-01", "阅读数：248", Knowledge_Menu_Animal_Pig_DetailActivity.class);
        Knowledge_Menu_Animal_Duck h4 = new Knowledge_Menu_Animal_Duck(R.mipmap.ic_launcher, "农大3号小型蛋鸡", "2017-03-30", "阅读数：4263", Knowledge_Menu_Animal_Pig_DetailActivity.class);


        list.add(h1);
        list.add(h2);
        list.add(h3);
        list.add(h4);
        adapter = new Knowledge_Menu_Animal_DuckAdapter(getApplicationContext(), list);
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