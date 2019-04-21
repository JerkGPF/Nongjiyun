package com.example.administrator.myapplication.fragment;


import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class My_AskFragment extends Fragment {
    private TextView textView;


    public My_AskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my__ask, container, false);

        textView =(TextView) view.findViewById(R.id.my_ask_tv);
        textView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        return view;
    }

}
