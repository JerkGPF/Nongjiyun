package com.example.administrator.myapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.myapplication.MainActivity;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.Ask_DetailActivity;
import com.example.administrator.myapplication.activity.Exchenge_DetailActivity;
import com.example.administrator.myapplication.activity.QuickQuestionSubmission;
import com.example.administrator.myapplication.adapter.Exchange_itemAdapter;
import com.example.administrator.myapplication.adapter.Home_Search_AnswerAdapter;
import com.example.administrator.myapplication.moduels.Exchange_item;
import com.example.administrator.myapplication.moduels.Home_Search_Answer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AskFragment extends Fragment {
    private List<Home_Search_Answer> lists;
    private ListView listView;
    private Home_Search_AnswerAdapter adapter;
    private Button quick;


    public AskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ask, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        quick =(Button)view.findViewById(R.id.quickask);
        quick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), QuickQuestionSubmission.class);
                startActivity(intent);
            }
        });


        listView = (ListView) view.findViewById(R.id.search_answer_lv);
        lists = new ArrayList<>();
        Home_Search_Answer h1 = new Home_Search_Answer(R.mipmap.icon_default_head,"陈永明","宿迁市  沭阳县  陇集镇","农技推广人员","粮经","水稻秧育",R.mipmap.img4,R.mipmap.home_lv_iv2,R.mipmap.img3,"2018-05-28","6",null);
        Home_Search_Answer h2 = new Home_Search_Answer(R.mipmap.icon_default_head, "丁海峰","南通市  通州区  刘桥镇","合作社","粮经","请问专家，这个淮安产的水稻育秧专用产品有啥不一样？能把2袋肥拌和在一起，放在秧盘细土里用吗？",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.img3,"2018-05-28","5",null);
        Home_Search_Answer h3 = new Home_Search_Answer(R.mipmap.icon_default_head, "阿狸","南京","推广人员","粮经","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28","10",null);
        Home_Search_Answer h4 = new Home_Search_Answer(R.mipmap.icon_default_head, "阿狸","南京","推广人员","粮经","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.img3,"2018-05-28","15",null);
        Home_Search_Answer h5 = new Home_Search_Answer(R.mipmap.icon_default_head, "阿狸","南京","推广人员","粮经","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28","8",null);
        Home_Search_Answer h6 = new Home_Search_Answer(R.mipmap.icon_default_head, "阿狸","南京","推广人员","粮经","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28","7",null);
        Home_Search_Answer h7 = new Home_Search_Answer(R.mipmap.icon_default_head, "阿狸","南京","推广人员","粮经","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28","2",null);
        Home_Search_Answer h8 = new Home_Search_Answer(R.mipmap.icon_default_head, "阿狸","南京","推广人员","粮经","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28","0",null);
        Home_Search_Answer h9 = new Home_Search_Answer(R.mipmap.icon_default_head, "阿狸","南京","推广人员","粮经","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28","9",null);
        Home_Search_Answer h10 = new Home_Search_Answer(R.mipmap.icon_default_head, "阿狸","南京","推广人员","粮经","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28","3",null);
        Home_Search_Answer h11 = new Home_Search_Answer(R.mipmap.icon_default_head, "阿狸","南京","推广人员","粮经","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28","5",null);


        lists.add(h1);
        lists.add(h2);
        lists.add(h3);
        lists.add(h4);
        lists.add(h5);
        lists.add(h6);
        lists.add(h7);
        lists.add(h8);
        lists.add(h9);
        lists.add(h10);
        lists.add(h11);


        adapter = new Home_Search_AnswerAdapter(getActivity(), lists);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Ask_DetailActivity.class);
                startActivity(intent);
            }
        });
    }


}
