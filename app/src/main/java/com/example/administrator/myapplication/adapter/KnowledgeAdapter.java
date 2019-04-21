package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Knowledge;
import com.example.administrator.myapplication.utils.ScreenUtil;
import com.example.administrator.myapplication.view.CustomToastView;

import java.util.List;

public class KnowledgeAdapter extends BaseAdapter {
    static CustomToastView customToastView;
    private List<Knowledge> datas;

    private Context context;


    public KnowledgeAdapter(Context context, List<Knowledge> datas) {
        this.context = context;
        this.datas = datas;
        // 布局装载器对象
    }

    // 适配器中数据集中数据的个数
    @Override
    public int getCount() {
        return 5;
    }

    // 获取数据集中与指定索引对应的数据项
    @Override
    public Object getItem(int position) {
        return position;
    }

    // 获取指定行对应的ID
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 获取每一个Item显示的内容
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RadioButton rb = new RadioButton(context);


        if (position ==1) {
            rb.setText("植保库");
            rb.setButtonDrawable(null);
            rb.setBackgroundColor(Color.WHITE);
            rb.setPadding(0,30,0,30);
            rb.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.icon_zhibao, 0, 0);
            rb.setCompoundDrawablePadding(ScreenUtil.dip2px(context, 5));
            rb.setGravity(Gravity.CENTER);
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast smileToast=new Toast(context.getApplicationContext());
                    //view布局
                    View smileView = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.knowledge_smile_toast,null,false);
                    TextView text = (TextView) smileView.findViewById(R.id.toastMessage);
                    text.setText("该功能正在开发中");
                    //给customToastView增加动画效果
                    customToastView=(CustomToastView) smileView.findViewById(R.id.smileView);
                    customToastView.startAnim();
                    text.setBackgroundResource(R.drawable.shape_knowledge_toast_text);
                    text.setTextColor(Color.parseColor("#FFFFFF"));
                    smileToast.setView(smileView);
                    smileToast.setDuration(Toast.LENGTH_SHORT);
                    smileToast.show();
                }
            });
        } else{
            rb.setText(datas.get(position).getName());
            rb.setButtonDrawable(null);
            rb.setBackgroundColor(Color.WHITE);
            rb.setPadding(0,30,0,30);
            rb.setCompoundDrawablesWithIntrinsicBounds(0, datas.get(position).getImg(), 0, 0);
            rb.setCompoundDrawablePadding(ScreenUtil.dip2px(context, 5));
            rb.setGravity(Gravity.CENTER);
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, datas.get(position).getaClass());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }

        return rb;
    }
}
