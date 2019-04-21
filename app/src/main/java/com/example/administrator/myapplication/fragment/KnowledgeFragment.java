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
import com.example.administrator.myapplication.activity.Knowledge_Menu_AnimalActivity;
import com.example.administrator.myapplication.activity.Knowledge_Menu_CropActivity;
import com.example.administrator.myapplication.activity.Knowledge_Menu_ProfessorActivity;
import com.example.administrator.myapplication.activity.Knowledge_Menu_TecActivity;
import com.example.administrator.myapplication.adapter.KnowledgeAdapter;
import com.example.administrator.myapplication.moduels.Knowledge;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class KnowledgeFragment extends Fragment {
    private List<Knowledge> lists;
    private GridView gridView;
    private KnowledgeAdapter adapter;



    public KnowledgeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_knowledge, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gridView = (GridView)view.findViewById(R.id.knowledge_gv);
        lists = new ArrayList<>();
        Knowledge h1 = new Knowledge(R.mipmap.icon_zuwu, "作物品种库", Knowledge_Menu_CropActivity.class);
        Knowledge h2 = new Knowledge(R.mipmap.icon_zhibao, "植保库", null);
        Knowledge h3 = new Knowledge(R.mipmap.icon_chuqin, "畜禽品种库", Knowledge_Menu_AnimalActivity.class);
        Knowledge h4 = new Knowledge(R.mipmap.icon_zhutui, "主推技术库", Knowledge_Menu_TecActivity.class);
        Knowledge h5 = new Knowledge(R.mipmap.icon_zjtx, "产业技术体系专家", Knowledge_Menu_ProfessorActivity.class);

        lists.add(h1);
        lists.add(h2);
        lists.add(h3);
        lists.add(h4);
        lists.add(h5);


        adapter = new KnowledgeAdapter(getActivity(), lists);
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
