package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.administrator.myapplication.MainActivity;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.Knowledge_Menu_ProfessorAdapter;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Professor;
import com.example.administrator.myapplication.view.HomeMenuGridView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class Knowledge_Menu_ProfessorActivity extends AppCompatActivity {
    private List<Knowledge_Menu_Professor> list;
    private HomeMenuGridView gridView;
    private Knowledge_Menu_ProfessorAdapter adapter;
    private Button button;
    private RefreshLayout refreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_menu__professor);
        refreshLayout = findViewById(R.id.refreshLayout);
        button=findViewById(R.id.knowledge_menu_professor_bt);//返回上一个activity
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initData();
        initEvent();

    }
    private void initEvent() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setEnableLoadMore(false);//禁止上划
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });


    }

    private void initData() {

        gridView =(HomeMenuGridView) findViewById(R.id.knowledge_menu_professor_gv);
        list=new ArrayList<Knowledge_Menu_Professor>();

        Knowledge_Menu_Professor h1=new Knowledge_Menu_Professor(R.mipmap.icon,null,Knowledge_Menu_Pro_RiceActivity.class);
        Knowledge_Menu_Professor h2=new Knowledge_Menu_Professor(R.mipmap.icon1,null,Knowledge_Menu_Pro_WheatActivity.class);
        Knowledge_Menu_Professor h3=new Knowledge_Menu_Professor(R.mipmap.icon2,null,Knowledge_Menu_Pro_TLTActivity.class);
        Knowledge_Menu_Professor h4=new Knowledge_Menu_Professor(R.mipmap.icon3,null,Knowledge_Menu_Pro_VegActivity.class);
        Knowledge_Menu_Professor h5=new Knowledge_Menu_Professor(R.mipmap.icon4,null,Knowledge_Menu_Pro_WatActivity.class);
        Knowledge_Menu_Professor h6=new Knowledge_Menu_Professor(R.mipmap.icon5,null,Knowledge_Menu_Pro_RiceActivity.class);
        Knowledge_Menu_Professor h7=new Knowledge_Menu_Professor(R.mipmap.icon6,null,Knowledge_Menu_Pro_RiceActivity.class);
        Knowledge_Menu_Professor h8=new Knowledge_Menu_Professor(R.mipmap.icon7,null,Knowledge_Menu_Pro_RiceActivity.class);
        Knowledge_Menu_Professor h9=new Knowledge_Menu_Professor(R.mipmap.icon8,null,Knowledge_Menu_Pro_RiceActivity.class);
        Knowledge_Menu_Professor h10=new Knowledge_Menu_Professor(R.mipmap.icon9,null,Knowledge_Menu_Pro_RiceActivity.class);
        Knowledge_Menu_Professor h11=new Knowledge_Menu_Professor(R.mipmap.icon10,null,Knowledge_Menu_Pro_RiceActivity.class);
        Knowledge_Menu_Professor h12=new Knowledge_Menu_Professor(R.mipmap.icon11,null,Knowledge_Menu_Pro_RiceActivity.class);
        Knowledge_Menu_Professor h13=new Knowledge_Menu_Professor(R.mipmap.icon12,null,Knowledge_Menu_Pro_RiceActivity.class);
        Knowledge_Menu_Professor h14=new Knowledge_Menu_Professor(R.mipmap.icon13,null,Knowledge_Menu_Pro_RiceActivity.class);
        Knowledge_Menu_Professor h15=new Knowledge_Menu_Professor(R.mipmap.icon0,null,Knowledge_Menu_Pro_RiceActivity.class);


        list.add(h3);
        list.add(h1);
        list.add(h4);
        list.add(h5);
        list.add(h2);
        list.add(h6);
        list.add(h7);
        list.add(h8);
        list.add(h9);
        list.add(h10);
        list.add(h14);
        list.add(h12);
        list.add(h13);
        list.add(h11);
        list.add(h15);


        adapter = new Knowledge_Menu_ProfessorAdapter(getApplicationContext(),list);
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
