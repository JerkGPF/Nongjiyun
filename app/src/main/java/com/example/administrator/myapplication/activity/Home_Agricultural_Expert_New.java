package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.Home_Expert_SuggestionAdapter;
import com.example.administrator.myapplication.fragment.Home_Details;
import com.example.administrator.myapplication.moduels.Home_TimeFarmingMenu;

import java.util.ArrayList;
import java.util.List;

public class Home_Agricultural_Expert_New extends AppCompatActivity {
    private ListView home_expert_new_lv;
    private List<Home_TimeFarmingMenu> expert_suggestion;
    private Home_Expert_SuggestionAdapter adapter;
    private ImageView agricultural_expert_back_iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__agricultural__expert__new);
        agricultural_expert_back_iv=(ImageView)findViewById(R.id.agricultural_expert_back_iv);
        agricultural_expert_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        init();
    }

    private void init() {
        home_expert_new_lv=(ListView)findViewById(R.id.home_expert_new_lv);
        expert_suggestion=new ArrayList<>();
        expert_suggestion.add(new Home_TimeFarmingMenu(R.mipmap.ic_launcher,"标题","时间","阅读量", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        expert_suggestion.add(new Home_TimeFarmingMenu(R.mipmap.ic_launcher,"标题","时间","阅读量", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        expert_suggestion.add(new Home_TimeFarmingMenu(R.mipmap.ic_launcher,"标题","时间","阅读量", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        expert_suggestion.add(new Home_TimeFarmingMenu(R.mipmap.ic_launcher,"标题","时间","阅读量", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        expert_suggestion.add(new Home_TimeFarmingMenu(R.mipmap.ic_launcher,"标题","时间","阅读量", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        expert_suggestion.add(new Home_TimeFarmingMenu(R.mipmap.ic_launcher,"标题","时间","阅读量", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        expert_suggestion.add(new Home_TimeFarmingMenu(R.mipmap.ic_launcher,"标题","时间","阅读量", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        expert_suggestion.add(new Home_TimeFarmingMenu(R.mipmap.ic_launcher,"标题","时间","阅读量", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        expert_suggestion.add(new Home_TimeFarmingMenu(R.mipmap.ic_launcher,"标题","时间","阅读量", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));

        adapter=new Home_Expert_SuggestionAdapter(this,expert_suggestion);
        home_expert_new_lv.setAdapter(adapter);

        home_expert_new_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Home_Agricultural_Expert_New.this,expert_suggestion.get(position).getUrl());
                intent.putExtra("view",expert_suggestion.get(position).getNeturl());
                startActivity(intent);
            }
        });
            }
}
