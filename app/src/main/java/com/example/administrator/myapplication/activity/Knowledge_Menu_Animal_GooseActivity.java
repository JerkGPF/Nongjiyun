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
import com.example.administrator.myapplication.adapter.Knowledge_Menu_Animal_GooseAdapter;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Animal_Goose;

import java.util.ArrayList;
import java.util.List;

public class Knowledge_Menu_Animal_GooseActivity extends AppCompatActivity {
    private Button button;
    private Knowledge_Menu_Animal_GooseAdapter adapter;
    private ListView listView;
    private List<Knowledge_Menu_Animal_Goose> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge__menu__animal__goose);
        initData();
        button = findViewById(R.id.knowledge_menu_animal_goose_bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        listView = (ListView) findViewById(R.id.knowledge_menu_animal_goose_lv);
        listView.setBackgroundColor(Color.WHITE);
        list = new ArrayList<Knowledge_Menu_Animal_Goose>();
        Knowledge_Menu_Animal_Goose h1 = new Knowledge_Menu_Animal_Goose(R.mipmap.ic_launcher, "白羽朗德鹅新品系", "2018-05-01", "阅读数：248", Knowledge_Menu_Animal_Pig_DetailActivity.class);
        Knowledge_Menu_Animal_Goose h2 = new Knowledge_Menu_Animal_Goose(R.mipmap.ic_launcher, "浙东白鹅", "2017-03-30", "阅读数：4263", Knowledge_Menu_Animal_Pig_DetailActivity.class);
        Knowledge_Menu_Animal_Goose h3 = new Knowledge_Menu_Animal_Goose(R.mipmap.ic_launcher, "泰州鹅", "2018-05-01", "阅读数：248", Knowledge_Menu_Animal_Pig_DetailActivity.class);
        Knowledge_Menu_Animal_Goose h4 = new Knowledge_Menu_Animal_Goose(R.mipmap.ic_launcher, "扬州鹅", "2017-03-30", "阅读数：4263", Knowledge_Menu_Animal_Pig_DetailActivity.class);
        Knowledge_Menu_Animal_Goose h5 = new Knowledge_Menu_Animal_Goose(R.mipmap.ic_launcher, "霍尔多巴鹅", "2017-03-30", "阅读数：4263", Knowledge_Menu_Animal_Pig_DetailActivity.class);


        list.add(h1);
        list.add(h2);
        list.add(h3);
        list.add(h4);
        list.add(h5);
        adapter = new Knowledge_Menu_Animal_GooseAdapter(getApplicationContext(), list);
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