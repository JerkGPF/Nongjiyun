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
import com.example.administrator.myapplication.adapter.Knowledge_Menu_Animal_SheepAdapter;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Animal_Sheep;

import java.util.ArrayList;
import java.util.List;

public class Knowledge_Menu_Animal_SheepActivity extends AppCompatActivity {

    private Button button;
    private List<Knowledge_Menu_Animal_Sheep> list;
    private Knowledge_Menu_Animal_SheepAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge__menu__animal__sheep);


        initData();
        button = findViewById(R.id.knowledge_menu_animal_sheep_bt);//返回上一个activity
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        listView = (ListView) findViewById(R.id.knowledge_menu_animal_sheep_lv);
        listView.setBackgroundColor(Color.WHITE);
        list = new ArrayList<Knowledge_Menu_Animal_Sheep>();
        Knowledge_Menu_Animal_Sheep h1 = new Knowledge_Menu_Animal_Sheep(R.mipmap.pig, "湖羊", "2018-05-01", "阅读数：248", Knowledge_Menu_Animal_Pig_DetailActivity.class);


        list.add(h1);

        adapter = new Knowledge_Menu_Animal_SheepAdapter(getApplicationContext(), list);
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