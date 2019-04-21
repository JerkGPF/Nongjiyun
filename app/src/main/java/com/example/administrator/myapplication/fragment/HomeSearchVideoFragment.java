package com.example.administrator.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.Home_MediaPlayer;
import com.example.administrator.myapplication.adapter.HomeVideoAdapter;
import com.example.administrator.myapplication.moduels.HomeVideoMenu;
import com.example.administrator.myapplication.view.GrideViewScroll;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeSearchVideoFragment extends Fragment {

    private HomeVideoAdapter adapter3;
    private GrideViewScroll grid_video;
    private List<HomeVideoMenu> videoMenus;
    private TextView video_tv;


    public HomeSearchVideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_search_video, container, false);
        video_tv=(TextView)view.findViewById(R.id.home_video_tv);
        grid_video=(GrideViewScroll)view.findViewById(R.id.grid_video);

        List<HomeVideoMenu>  videoMenus=new ArrayList<>();
        videoMenus.add(new HomeVideoMenu(R.mipmap.video1,"球根花卉种类及生产技术要点",Home_MediaPlayer.class));
        videoMenus.add(new HomeVideoMenu(R.mipmap.video2,"农村电商发展及案例解析",Home_MediaPlayer.class));
        videoMenus.add(new HomeVideoMenu(R.mipmap.video2,"球根花卉种类及生产技术要点",Home_MediaPlayer.class));
        videoMenus.add(new HomeVideoMenu(R.mipmap.video1,"农村电商发展及案例解析",Home_MediaPlayer.class));
        adapter3=new HomeVideoAdapter(getActivity(),videoMenus);
        grid_video.setAdapter(adapter3);

        return  view;
    }

}
