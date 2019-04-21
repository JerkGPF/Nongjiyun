package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.example.administrator.myapplication.MainActivity;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.Knowledge_Menu_AnimalAdapter;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Animal;

import java.util.ArrayList;
import java.util.List;

public class Knowledge_Menu_AnimalActivity extends AppCompatActivity {

    private List<Knowledge_Menu_Animal> list;
    private GridView gridView;
    private Knowledge_Menu_AnimalAdapter adapter;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_menu__animal);

        button=findViewById(R.id.knowledge_menu_animal_bt);//返回上一个activity
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initData();

    }

    private void initData() {

        gridView =(GridView)findViewById(R.id.knowledge_menu_animal_gv);
        list=new ArrayList<Knowledge_Menu_Animal>();

        Knowledge_Menu_Animal h1=new Knowledge_Menu_Animal(R.mipmap.animal_pig,"猪",Knowledge_Menu_Animal_PigActivity.class);
        Knowledge_Menu_Animal h2=new Knowledge_Menu_Animal(R.mipmap.animal2,"羊",Knowledge_Menu_Animal_SheepActivity.class);
        Knowledge_Menu_Animal h3=new Knowledge_Menu_Animal(R.mipmap.animal_chicken,"蛋鸡",Knowledge_Menu_Animal_EggActivity.class);
        Knowledge_Menu_Animal h4=new Knowledge_Menu_Animal(R.mipmap.animal_chicken1,"肉鸡",Knowledge_Menu_Animal_ChickenActivity.class);
        Knowledge_Menu_Animal h5=new Knowledge_Menu_Animal(R.mipmap.animal_duck1,"鸭",Knowledge_Menu_Animal_DuckActivity.class);
        Knowledge_Menu_Animal h6=new Knowledge_Menu_Animal(R.mipmap.animal_duck,"鹅",Knowledge_Menu_Animal_GooseActivity.class);
        Knowledge_Menu_Animal h7=new Knowledge_Menu_Animal(R.mipmap.animal3,"牛",Knowledge_Menu_Animal_CattleActivity.class);
        Knowledge_Menu_Animal h8=new Knowledge_Menu_Animal(R.mipmap.animal1,"鸽",Knowledge_Menu_Animal_DoveActivity.class);
        Knowledge_Menu_Animal h9=new Knowledge_Menu_Animal(R.mipmap.animal,"兔",Knowledge_Menu_Animal_RabbitActivity.class);
        Knowledge_Menu_Animal h10=new Knowledge_Menu_Animal(R.mipmap.animal4,"其他",null);

//        list.add(h1);
//        list.add(h2);
//        list.add(h3);
//        list.add(h4);
//        list.add(h5);
//        list.add(h6);
//        list.add(h7);
//        list.add(h8);
//        list.add(h9);
//        list.add(h10);


        list.add(h2);
        list.add(h1);
        list.add(h3);
        list.add(h5);
        list.add(h4);
        list.add(h7);
        list.add(h6);
        list.add(h9);
        list.add(h8);
        list.add(h10);


        adapter = new Knowledge_Menu_AnimalAdapter(getApplicationContext(),list);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}
