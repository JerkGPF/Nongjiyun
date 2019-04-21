package com.example.administrator.myapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.BrandCompanyDetailActivity;
import com.example.administrator.myapplication.activity.BrandDetailActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BrandNongYaoFragment extends Fragment {
    private ImageView imageView;
    private ImageView brand;


    public BrandNongYaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_brand_nong_yao, container, false);
        imageView=view.findViewById(R.id.brand_nongyao_iv);
        brand = view .findViewById(R.id.brand_iv1);
        brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),BrandCompanyDetailActivity.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),BrandDetailActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
