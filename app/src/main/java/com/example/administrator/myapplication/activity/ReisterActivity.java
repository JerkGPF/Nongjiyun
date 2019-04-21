package com.example.administrator.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.utils.MessageTest;
import com.example.administrator.myapplication.utils.TelNumMatch;
import com.example.administrator.myapplication.utils.UserMessage;
import com.example.administrator.myapplication.view.RefuseToastView;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


public class ReisterActivity extends AppCompatActivity {
    private EditText et_phone;//手机号码
    private EditText et_num;//验证码
    private Button bt_num;//获取验证码
    private Button bt_next;//下一步
    private Button reister_iv_next;
    private ImageView reister_back_bt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reister);
        x.view().inject(this);
        reister_iv_next=(Button)findViewById(R.id.reister_iv_next);
        et_phone=(EditText)findViewById(R.id.reister_et_phone);
        bt_num = (Button)findViewById(R.id.reister_bt_yzm);
        et_num=(EditText)findViewById(R.id.reister_et_yzm);
        reister_back_bt=(ImageView)findViewById(R.id.reister_back_bt) ;

        reister_back_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        reister_iv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("message",MODE_PRIVATE);
                String code=sharedPreferences.getString("data","");
                String phonenumber=et_phone.getText().toString();
                String message=et_num.getText().toString();
                if (et_phone.length()==0&&et_num.length()==0){
                    Toast.makeText(ReisterActivity.this,"请输入手机号",Toast.LENGTH_SHORT).show();
                }else if (code.equals(message)){
                    Toast.makeText(ReisterActivity.this,"验证成功",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(ReisterActivity.this,RegisterInfoActivity.class);
                    intent.putExtra("phonenumber",phonenumber);
                    startActivity(intent);
                    finish();
                }else if (!code.equals(message)){
                    Toast.makeText(ReisterActivity.this,"验证码错误",Toast.LENGTH_SHORT).show();
                }




            }
        });
        bt_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userPhoneNumber = et_phone.getText().toString();
                if (et_phone.length() == 0) {
                    Toast refuseToast = new Toast(ReisterActivity.this.getApplicationContext());
                    //view布局
                    View refuseView = LayoutInflater.from(ReisterActivity.this.getApplicationContext()).inflate(R.layout.refuse_toast_view, null, false);
                    TextView text = (TextView) refuseView.findViewById(R.id.refuse_toastMessage);
                    text.setText("手机号码不能为空");
                    //给增加动画效果
                    RefuseToastView refuseToastView = (RefuseToastView) refuseView.findViewById(R.id.refuse_View);
                    refuseToastView.startAnim();
                    text.setBackgroundResource(R.drawable.shape_refuse_toast_text);
                    text.setTextColor(Color.parseColor("#FFFFFF"));
                    refuseToast.setView(refuseView);
                    refuseToast.setDuration(Toast.LENGTH_SHORT);
                    refuseToast.show();

                } else if (!TelNumMatch.isValidPhoneNumber(userPhoneNumber)) {
                    Toast refuseToast = new Toast(ReisterActivity.this.getApplicationContext());
                    //view布局
                    View refuseView = LayoutInflater.from(ReisterActivity.this.getApplicationContext()).inflate(R.layout.refuse_toast_view, null, false);
                    TextView text = (TextView) refuseView.findViewById(R.id.refuse_toastMessage);
                    text.setText("输入正确的手机号码");
                    //给增加动画效果
                    RefuseToastView refuseToastView = (RefuseToastView) refuseView.findViewById(R.id.refuse_View);
                    refuseToastView.startAnim();
                    text.setBackgroundResource(R.drawable.shape_refuse_toast_text);
                    text.setTextColor(Color.parseColor("#FFFFFF"));
                    refuseToast.setView(refuseView);
                    refuseToast.setDuration(Toast.LENGTH_SHORT);
                    refuseToast.show();
                } else {

                };

                String phone = et_phone.getText().toString();
                String msg = "手机号：" + phone;

                JSONObject js_request = new JSONObject();

                try {
                    js_request.put("account", phone);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                //下面开始请求后台地址
                RequestParams params = new RequestParams("http://47.100.175.180/nonjiyun/getMobileMessage/"+phone);
                params.setAsJsonContent(true);
                params.setBodyContent(js_request.toString());
                x.http().get(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onCancelled(CancelledException arg0) {

                    }

                    @Override
                    public void onError(Throwable arg0, boolean arg1) {
                        // TODO Auto-generated method stub
                        Log.e("错误", arg0.toString());
                    }

                    @Override
                    public void onFinished() {
                        // TODO Auto-generated method stub

                    }

                    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
                    @Override
                    public void onSuccess(String arg0) {
                        System.out.println(arg0);
                        Toast.makeText(ReisterActivity.this,arg0,Toast.LENGTH_SHORT).show();
                        try {
                            //服务器返回的是一个json封装的字符串，将其转换为json对象
                            JSONObject jsonObject =  new JSONObject(arg0);
                            //       final  String data=jsonObject.getString("data");
                            //   JSONObject object =  jsonObject.getJSONObject("agr0");
                            MessageTest msg = new Gson().fromJson(jsonObject.toString(),MessageTest.class);
                            SharedPreferences.Editor editor = getSharedPreferences("message", MODE_PRIVATE).edit();
                            editor.putString("msg", msg.getMsg());
                            editor.putString("data",msg.getData());
                            editor.putString("status",msg.getStatus());
                            editor.apply();





                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                });

            }
        });
    }
}

