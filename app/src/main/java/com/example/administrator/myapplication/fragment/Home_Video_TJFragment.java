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
import android.widget.GridView;

import com.example.administrator.myapplication.MainActivity;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.Home_Video_TJAdapter;
import com.example.administrator.myapplication.moduels.Knowledge;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Video_TJFragment extends Fragment {
    private List<Knowledge> lists;
    private GridView gridView;
    private Home_Video_TJAdapter adapter;


    public Home_Video_TJFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home__video__tj, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gridView = (GridView)view.findViewById(R.id.home_video_gv);
        lists = new ArrayList<>();
        Knowledge h1 = new Knowledge(R.mipmap.video, "江苏粮食收购政策解读与形势分析", null);
        Knowledge h2 = new Knowledge(R.mipmap.video0, "“双减”形势下应对鲜果病虫害绿色防控技术", null);
        Knowledge h3 = new Knowledge(R.mipmap.video1, "夏季蛋鸡饲养管理技术", null);
        Knowledge h4 = new Knowledge(R.mipmap.video2, "秸秆禁烧与秸秆综合利用",null);
        Knowledge h5 = new Knowledge(R.mipmap.video3, "培育“味稻”品种  打造“苏米”品牌", null);

        lists.add(h1);
        lists.add(h2);
        lists.add(h3);
        lists.add(h4);
        lists.add(h5);
        lists.add(h1);
        lists.add(h2);
        lists.add(h3);
        lists.add(h4);
        lists.add(h5);


        adapter = new Home_Video_TJAdapter(getActivity(), lists);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
