package com.example.administrator.myapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.example.administrator.myapplication.activity.BrandActivity;
import com.example.administrator.myapplication.activity.SupplyInfActivity;
import com.example.administrator.myapplication.activity.SupplyInformationActivity;
import com.example.administrator.myapplication.adapter.GridViewAdapter;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.fragment.Home_Details;
import com.example.administrator.myapplication.moduels.HomeMenu;
import com.example.administrator.myapplication.moduels.HomeMoreMenu;
import com.example.administrator.myapplication.moduels.MyDragGridView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class more extends AppCompatActivity {
    private List<HashMap<String, Object>> dataSourceList = new ArrayList<HashMap<String, Object>>();
    private GridViewAdapter adapter;
    private GridView gridView2;
    private List<HomeMoreMenu> strList;
    private List<String >strings;
    private List<Integer>maps;
    private ImageView home_grid_more_btn_back;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_more);
        home_grid_more_btn_back=(ImageView)findViewById(R.id.home_grid_more_btn_back);
        home_grid_more_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        strings=new ArrayList<>();
        maps=new ArrayList<>();
        strings.add("专业合作");
        strings.add("应时农事");
        strings.add("农业科技");
        strings.add("农业专家");
        strings.add("农业政策");
        strings.add("科技专项");
        strings.add("市场行情");
        strings.add("生活服务");
        maps.add(R.mipmap.zhuanyehezuo);
        maps.add(R.mipmap.yongshinongshi);
        maps.add(R.mipmap.nongyekeji);
        maps.add(R.mipmap.nongyezhuanjia);
        maps.add(R.mipmap.nongyezhengce);
        maps.add(R.mipmap.kejizhuanxiang);
        maps.add(R.mipmap.shichanghangqing);
        maps.add(R.mipmap.shenghuofuwu);


        initView();
        initData();

        initDrag();

    }

    private void initDrag() {
        MyDragGridView mDragGridView = (MyDragGridView) findViewById(R.id.dragGridView);
        for (int i = 0; i < 8; i++) {
            HashMap<String, Object> itemHashMap = new HashMap<String, Object>();
            itemHashMap.put("item_image",maps.get(i));
            itemHashMap.put("item_text",strings.get(i));
            dataSourceList.add(itemHashMap);
        }


        final SimpleAdapter mSimpleAdapter = new SimpleAdapter(this, dataSourceList,
                R.layout.more_dragitem,new String[] { "item_image", "item_text" },
                new int[] { R.id.item_image, R.id.item_text });

        mDragGridView.setAdapter(mSimpleAdapter);

        mDragGridView.setOnChangeListener(new MyDragGridView.OnChanageListener() {

            @Override
            public void onChange(int from, int to) {
//                HashMap<String, Object> temp = dataSourceList.get(from);
                // 直接交互item
//              dataSourceList.set(from, dataSourceList.get(to));
//              dataSourceList.set(to, temp);
//              dataSourceList.set(to, temp);


                //这里的处理需要注意下
                if(from < to){
                    for(int i=from; i<to; i++){
                        Collections.swap(dataSourceList, i, i+1);
                    }
                }else if(from > to){
                    for(int i=from; i>to; i--){
                        Collections.swap(dataSourceList, i, i-1);
                    }
                }

                mSimpleAdapter.notifyDataSetChanged();
            }
        });

        mDragGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    public void initData() {

        strList = new ArrayList<>();
        strList.add(new HomeMoreMenu(R.mipmap.yunshangzhineng, "云上智农", null));
        strList.add(new HomeMoreMenu(R.mipmap.shilidianfan, "示例典范", null));
        strList.add(new HomeMoreMenu(R.mipmap.nongyeqixiang, "农业气象", null));
        strList.add(new HomeMoreMenu(R.mipmap.gongqiuxinxi, "供求信息",SupplyInfActivity.class));
        strList.add(new HomeMoreMenu(R.mipmap.chuangyezhifu, "创业致富", null));
        strList.add(new HomeMoreMenu(R.mipmap.xiangcunluxing, "乡村旅游", null));
        strList.add(new HomeMoreMenu(R.mipmap.pinpainongzi, "品牌农资", BrandActivity.class));
        adapter = new GridViewAdapter(more.this, strList);

        gridView2.setAdapter(adapter);
    }
    private void initView() {

       gridView2 = (GridView)findViewById(R.id.drag_grid_view2);
    }
}



