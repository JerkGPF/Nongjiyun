package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Model01;
import com.taobao.library.BaseBannerAdapter;
import com.taobao.library.VerticalBannerView;

import java.util.List;

/**
 * Description:
 * <p/>
 * Created by rowandjj(chuyi)<br/>
 * Date: 16/1/7<br/>
 * Time: 下午2:41<br/>
 */
public class SampleAdapter03 extends BaseBannerAdapter<Model01> {
    private Context context;
    private List<Model01> datas03;


    public SampleAdapter03(Context context, List<Model01> datas03) {
        super(datas03);
        this.context=context;
    }


    @Override
    public View getView(VerticalBannerView parent) {

        return LayoutInflater.from(context).inflate(R.layout.item_03,null);
    }

    @Override
    public void setItem( View view,  Model01 datas03) {
        TextView tv = (TextView)view.findViewById(R.id.title);
        tv.setText(datas03.getTitle());


//        TextView tag = (TextView) view.findViewById(R.id.tag);
//        tag.setText(datas03.getUrl());

    }
}
