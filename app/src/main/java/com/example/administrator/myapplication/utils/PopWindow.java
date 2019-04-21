package com.example.administrator.myapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.administrator.myapplication.MainActivity;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.AddFriendActivity;
import com.example.administrator.myapplication.activity.HuiHuaActivity;
import com.example.administrator.myapplication.activity.MyEWMActivity;
import com.example.administrator.myapplication.activity.ScanActivity;
import com.example.administrator.myapplication.zxing.activity.CaptureActivity;

import static android.app.Activity.RESULT_OK;
import static com.mob.MobSDK.getContext;

/**
 * <p>Title:PopWindow</p>
 * <p>Description: 自定义PopupWindow</p>
 * @author syz
 * @date 2016-3-14
 */
public class PopWindow extends PopupWindow{
    private View conentView;

    //打开扫描界面请求码
    private int REQUEST_CODE = 0x01;
    //扫描成功返回码
    private int RESULT_OK = 0xA1;



    public PopWindow(final Activity context){
        final LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.popup_window, null);
        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        // 设置SelectPicPopupWindow的View
        this.setContentView(conentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(w / 3+150);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);
        this.setAnimationStyle(android.R.style.Animation_Dialog);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimationPreview);

        conentView.findViewById(R.id.about).setOnClickListener(new OnClickListener() {

            @Override//扫一扫
            public void onClick(View arg0) {
                PopWindow.this.dismiss();

                if(CommonUtil.isCameraCanUse()){
                    Intent intent = new Intent(arg0.getContext(), CaptureActivity.class);
                    context.startActivityForResult(intent, REQUEST_CODE);
                }else{
                    Toast.makeText(getContext(),"请打开此应用的摄像头权限！",Toast.LENGTH_SHORT).show();
                }
//                Intent intent=new Intent();
//                intent.setClass(arg0.getContext(),ScanActivity.class);
//                context.startActivity(intent);
            }
        });
        conentView.findViewById(R.id.ability_logout).setOnClickListener(new OnClickListener() {

            @Override//我的二维码
            public void onClick(View arg0) {
                Intent intent=new Intent();
                intent.setClass(arg0.getContext(),MyEWMActivity.class);
                context.startActivity(intent);
                PopWindow.this.dismiss();
            }
        });
        conentView.findViewById(R.id.settings).setOnClickListener(new OnClickListener() {

            @Override//添加朋友
            public void onClick(View arg0) {
                Intent intent=new Intent();
                intent.setClass(arg0.getContext(),AddFriendActivity.class);
                context.startActivity(intent);

                PopWindow.this.dismiss();
            }
        });
    }

    /**
     * 显示popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent, parent.getLayoutParams().width / 2, 5);
        } else{
            this.dismiss();
        }
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        //扫描结果回调
//        if (resultCode == RESULT_OK) { //RESULT_OK = -1
//            Bundle bundle = data.getExtras();
//            String scanResult = bundle.getString("qr_scan_result");
//            //将扫描出的信息显示出来
//            qrCodeText.setText(scanResult);
//        }
//    }

}