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
import com.example.administrator.myapplication.adapter.Knowledge_Menu_Animal_EggAdapter;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Animal_Egg;

import java.util.ArrayList;

public class Knowledge_Menu_Animal_EggActivity extends AppCompatActivity {
    private Button button;
    private ArrayList<Knowledge_Menu_Animal_Egg> list;
    private Knowledge_Menu_Animal_EggAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge__menu__animal__egg);
        initData();
        button = findViewById(R.id.knowledge_menu_animal_egg_bt);//返回上一个activity
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        listView = (ListView) findViewById(R.id.knowledge_menu_animal_egg_lv);
        listView.setBackgroundColor(Color.WHITE);
        list = new ArrayList<Knowledge_Menu_Animal_Egg>();
        Knowledge_Menu_Animal_Egg h1 = new Knowledge_Menu_Animal_Egg(R.mipmap.ic_launcher, "苏禽绿壳蛋鸡", "2018-05-01", "阅读数：248", Knowledge_Menu_Animal_Pig_DetailActivity.class);
        Knowledge_Menu_Animal_Egg h2 = new Knowledge_Menu_Animal_Egg(R.mipmap.ic_launcher, "罗曼褐蛋鸡", "2017-03-30", "阅读数：4263", Knowledge_Menu_Animal_Pig_DetailActivity.class);
        Knowledge_Menu_Animal_Egg h3 = new Knowledge_Menu_Animal_Egg(R.mipmap.ic_launcher, "京红1号蛋鸡", "2018-05-01", "阅读数：248", Knowledge_Menu_Animal_Pig_DetailActivity.class);
        Knowledge_Menu_Animal_Egg h4 = new Knowledge_Menu_Animal_Egg(R.mipmap.ic_launcher, "农大3号小型蛋鸡", "2017-03-30", "阅读数：4263", Knowledge_Menu_Animal_Pig_DetailActivity.class);


        list.add(h1);
        list.add(h2);
        list.add(h3);
        list.add(h4);
        adapter = new Knowledge_Menu_Animal_EggAdapter(getApplicationContext(), list);
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