package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.Knowledge_Menu_Pro_Veg_DirAdapter;
import com.example.administrator.myapplication.adapter.Knowledge_Menu_Pro_Veg_MainAdapter;
import com.example.administrator.myapplication.adapter.Knowledge_Menu_Pro_Veg_NormalAdapter;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Pro_Veg_Dir;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Pro_Veg_Main;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Pro_Veg_Normal;
import com.example.administrator.myapplication.view.MyListView;

import java.util.ArrayList;
import java.util.List;

public class Knowledge_Menu_Pro_VegActivity extends AppCompatActivity {
    //首席专家
    private Button button;
    private List<Knowledge_Menu_Pro_Veg_Main> list;
    private Knowledge_Menu_Pro_Veg_MainAdapter adapter;
    private MyListView listView;


    //岗位专家
    private List<Knowledge_Menu_Pro_Veg_Normal> lt;
    private Knowledge_Menu_Pro_Veg_NormalAdapter ap;
    private MyListView lv;

    //基地主任
    private List<Knowledge_Menu_Pro_Veg_Dir> ls;
    private Knowledge_Menu_Pro_Veg_DirAdapter dirAdapter;
    private MyListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge__menu__pro__veg);

        initFirst();
        initSecond();
        initThird();
        button = findViewById(R.id.knowledge_menu_pro_veg_bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void initFirst() {
        listView = (MyListView) findViewById(R.id.knowledge_menu_pro_main_veg_lv);
        listView.setBackgroundColor(Color.WHITE);
        list = new ArrayList<Knowledge_Menu_Pro_Veg_Main>();
        Knowledge_Menu_Pro_Veg_Main h1 = new Knowledge_Menu_Pro_Veg_Main(R.mipmap.pro_head, "张洪程", "江苏现代农业（水稻）产业技术体系集成创新中心", "首席专家", "集成创新", Knowledge_Menu_Animal_Pig_DetailActivity.class);


        list.add(h1);
        adapter = new Knowledge_Menu_Pro_Veg_MainAdapter(list, getApplicationContext());
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

    private void initSecond() {
        lv = (MyListView) findViewById(R.id.knowledge_menu_pro_normal_veg_lv);
        lv.setBackgroundColor(Color.WHITE);
        lt = new ArrayList<Knowledge_Menu_Pro_Veg_Normal>();
        Knowledge_Menu_Pro_Veg_Normal h1 = new Knowledge_Menu_Pro_Veg_Normal(R.mipmap.pro_head, "周宏", "江苏现代农业（水稻）产业技术体系产业经济研究团队", "岗位专家", "旱杂粮", null);
        Knowledge_Menu_Pro_Veg_Normal h2 = new Knowledge_Menu_Pro_Veg_Normal(R.mipmap.pro_head, "杨洪建", "江苏现代农业（水稻）产业技术体系产业经济研究团队", "岗位专家", "豆类", null);
        Knowledge_Menu_Pro_Veg_Normal h3 = new Knowledge_Menu_Pro_Veg_Normal(R.mipmap.pro_head, "徐晓杰", "江苏现代农业（水稻）产业技术体系产业经济研究团队", "岗位专家", "集成创新", null);
        Knowledge_Menu_Pro_Veg_Normal h4 = new Knowledge_Menu_Pro_Veg_Normal(R.mipmap.pro_head, "谢成林", "江苏现代农业（水稻）产业技术体系产业经济研究团队", "岗位专家", "花生", null);
        Knowledge_Menu_Pro_Veg_Normal h5 = new Knowledge_Menu_Pro_Veg_Normal(R.mipmap.pro_head, "李刚华", "江苏现代农业（水稻）产业技术体系产业经济研究团队", "岗位专家", "集成创新", null);
        Knowledge_Menu_Pro_Veg_Normal h6 = new Knowledge_Menu_Pro_Veg_Normal(R.mipmap.pro_head, "周宏", "江苏现代农业（水稻）产业技术体系产业经济研究团队", "岗位专家", "集成创新", null);

        lt.add(h1);
        lt.add(h2);
        lt.add(h3);
        lt.add(h4);
        lt.add(h5);
        lt.add(h6);

        ap = new Knowledge_Menu_Pro_Veg_NormalAdapter(lt, getApplicationContext());
        lv.setAdapter(ap);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), list.get(position).getaClass());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
            }
        });
    }

    private void initThird() {
        myListView = (MyListView) findViewById(R.id.knowledge_menu_pro_dir_veg_lv);
        myListView.setBackgroundColor(Color.WHITE);
        ls = new ArrayList<Knowledge_Menu_Pro_Veg_Dir>();
        Knowledge_Menu_Pro_Veg_Dir h1 = new Knowledge_Menu_Pro_Veg_Dir(R.mipmap.pro_head, "周宏", "江苏现代农业（水稻）产业技术体系产业经济研究团队", "基地主任", "集成创新", null);
        Knowledge_Menu_Pro_Veg_Dir h2 = new Knowledge_Menu_Pro_Veg_Dir(R.mipmap.pro_head, "杨洪建", "江苏现代农业（水稻）产业技术体系产业经济研究团队", "基地主任", "花生", null);
        Knowledge_Menu_Pro_Veg_Dir h3 = new Knowledge_Menu_Pro_Veg_Dir(R.mipmap.pro_head, "徐晓杰", "江苏现代农业（水稻）产业技术体系产业经济研究团队", "基地主任", "中药材", null);
        Knowledge_Menu_Pro_Veg_Dir h4 = new Knowledge_Menu_Pro_Veg_Dir(R.mipmap.pro_head, "谢成林", "江苏现代农业（水稻）产业技术体系产业经济研究团队", "基地主任", "集成创新", null);
        Knowledge_Menu_Pro_Veg_Dir h5 = new Knowledge_Menu_Pro_Veg_Dir(R.mipmap.pro_head, "李刚华", "江苏现代农业（水稻）产业技术体系产业经济研究团队", "基地主任", "玉米", null);
        Knowledge_Menu_Pro_Veg_Dir h6 = new Knowledge_Menu_Pro_Veg_Dir(R.mipmap.pro_head, "周宏", "江苏现代农业（水稻）产业技术体系产业经济研究团队", "基地主任", "集成创新", null);

        ls.add(h1);
        ls.add(h2);
        ls.add(h3);
        ls.add(h4);
        ls.add(h5);
        ls.add(h6);

        dirAdapter = new Knowledge_Menu_Pro_Veg_DirAdapter(ls, getApplicationContext());
        myListView.setAdapter(dirAdapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), list.get(position).getaClass());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
            }
        });
    }
}
