package com.example.administrator.myapplication.fragment;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.Activity_login;
import com.example.administrator.myapplication.activity.MyAskActivity;
import com.example.administrator.myapplication.activity.MyCollectionActivity;
import com.example.administrator.myapplication.activity.MyDataActivity;
import com.example.administrator.myapplication.activity.MyEWMActivity;
import com.example.administrator.myapplication.activity.MyShareActivity;
import com.example.administrator.myapplication.activity.My_AnswerActivity;
import com.example.administrator.myapplication.activity.My_FeedBackActivity;
import com.example.administrator.myapplication.activity.My_PushActivity;
import com.example.administrator.myapplication.activity.My_SettingActivity;
import com.example.administrator.myapplication.view.CustomToastView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {
    private RadioButton rbqd;
    private RadioButton rbshop;
    private RadioButton rbjf;
    private RadioButton rbask;
    private RadioButton rbanswer;
    private RadioButton rbex;
    private RadioButton rbcollection;
    private RadioButton rbfocus;
    private RadioButton rbgq;
    private RadioButton rbteach;
    private RadioButton rbpush;
    private RadioButton rbset;
    private RadioButton rbfeedback;
    private RadioButton rbshare;
    private RadioButton rbewm;
    private LinearLayout linearLayout;
    static CustomToastView customToastView;
    private Context context;
    private TextView tv_phone;
    private TextView tv_type;
    private TextView tv_nickname;





    public MyFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

           View view=inflater.inflate(R.layout.fragment_my, container, false);
        initQD(view);//签到
        initJF(view);//积分
        initShop(view);//积分商城
        initAsk(view);//我的提问
        initAnswer(view);//我的回答
        initEx(view);//我的交流
        initCollection(view);//我的收藏
        initFocus(view);//我的关注
        initGQ(view);//我的供求
        initTeach(view);//我的培训班
        initTG(view);//我的推广
        initSetting(view);//系统设置
        initFeedBack(view);//意见反馈
        initShare(view);//分享农技耘
        initEwm(view);//我的二维码



        linearLayout =(LinearLayout)view.findViewById(R.id.line_me);//登录
        tv_phone = (TextView)view.findViewById(R.id.tv_phone);
        tv_type=(TextView)view.findViewById(R.id.tv_type);
        tv_nickname=(TextView)view.findViewById(R.id.mydata_login_tv);
        return view;

    }


    @Override
    public void onResume() {

        SharedPreferences sp=getActivity().getSharedPreferences("admin",Context.MODE_PRIVATE);
        tv_nickname.setText(sp.getString("nickname",""));
        tv_type.setText(sp.getString("role",""));

        linearLayout.setOnClickListener(new View.OnClickListener() {
            String name = tv_nickname.getText().toString();
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(getActivity(),MyDataActivity.class);
                    startActivity(intent);

            }
        });
        super.onResume();
    }




    //签到
    private void initQD(View view) {
        rbqd = (RadioButton)view.findViewById(R.id.qiandao_my_rb);
        rbqd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MyFragment.this.getContext());
                dialog.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
                View contentView = LayoutInflater.from(MyFragment.this.getContext()).inflate(R.layout.dialog_sign, null);
                dialog.setContentView(contentView);
                Button cancel = contentView.findViewById(R.id.submit_bt);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                //背景透明
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.show();
                Window window = dialog.getWindow();
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.gravity = Gravity.CENTER;
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                window.setAttributes(lp);
                window.setWindowAnimations(R.style.mystyle);  //添加动画
                dialog.setCanceledOnTouchOutside(true);
            }
        });

    }

    //积分
    private void initJF(View view) {
        rbjf = (RadioButton)view.findViewById(R.id.jifen_my_rb);
    }

    //积分商城
    private void initShop(View view) {
        rbshop=(RadioButton)view.findViewById(R.id.shop_my_rb);
        rbshop.setButtonDrawable(null);
        rbshop.setBackgroundColor(Color.WHITE);
        rbshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast smileToast=new Toast(MyFragment.this.getContext());
                //view布局
                View smileView = LayoutInflater.from(MyFragment.this.getContext()).inflate(R.layout.knowledge_smile_toast,null,false);
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

    }
    //我的提问
    private void initAsk(View view) {
        rbask =(RadioButton)view.findViewById(R.id.ask_my_rb);
        rbask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), MyAskActivity.class);
                startActivity(intent);
            }
        });
    }

    //我的回答
    private void initAnswer(View view) {
        rbanswer = (RadioButton)view.findViewById(R.id.answer_my_rb);
        rbanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),My_AnswerActivity.class);
                startActivity(intent);
            }
        });

    }

    //交流
    private void initEx(View view) {
    }

    //收藏
    private void initCollection(View view) {
        rbcollection = (RadioButton)view.findViewById(R.id.collection_my_rb);
        rbcollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MyCollectionActivity.class);
                startActivity(intent);
            }
        });

    }

    //关注
    private void initFocus(View view) {
    }

    //供求
    private void initGQ(View view) {
    }

    //培训班
    private void initTeach(View view) {
    }

    //推广
    private void initTG(View view) {
        rbpush = (RadioButton)view.findViewById(R.id.push_my_rb);
        rbpush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),My_PushActivity.class);
                startActivity(intent);
            }
        });
    }

    //系统设置
    private void initSetting(View view) {
        rbset =(RadioButton)view.findViewById(R.id.setting_my_rb);
        rbset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),My_SettingActivity.class);
                startActivity(intent);
            }
        });
    }

    //意见反馈
    private void initFeedBack(View view) {
        rbfeedback =(RadioButton)view.findViewById(R.id.advice_my_rb) ;
        rbfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), My_FeedBackActivity.class);
                startActivity(intent);
            }
        });

    }

    //分享农技耘
    private void initShare(View view) {
        rbshare =(RadioButton)view.findViewById(R.id.share_my_rb);
        rbshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), MyShareActivity.class);
                startActivity(intent);
            }
        });
    }

    //我的二维码
    private void initEwm(View view) {
        rbewm = (RadioButton)view.findViewById(R.id.ewm_my_rb);
        rbewm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),MyEWMActivity.class);
                startActivity(intent);
            }
        });
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode==12 && resultCode==21){
//            String name=data.getStringExtra("name");
//            Toast.makeText(getActivity(),name,Toast.LENGTH_SHORT).show();
//        }
//    }
}
