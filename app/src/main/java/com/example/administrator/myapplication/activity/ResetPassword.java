package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.utils.MessageTest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class ResetPassword extends AppCompatActivity {
    private EditText et_phone;
    private EditText et_password;
    private EditText et_password_ok;
    private Button reset_pass_iv_next;
    private ImageView reister_back_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        reister_back_bt=(ImageView)findViewById(R.id.reister_back_bt);
        reister_back_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        et_password=(EditText)findViewById(R.id.et_password);
        et_password_ok=(EditText)findViewById(R.id.et_password_ok);
        et_phone=(EditText)findViewById(R.id.et_phone);
        reset_pass_iv_next=(Button)findViewById(R.id.reset_pass_iv_next);
        Intent intent=getIntent();
        String phonenumber=intent.getStringExtra("phonenumber");
        et_phone.setText(phonenumber);
        reset_pass_iv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info_passworf= et_password.getText().toString();

                final String phone=et_phone.getText().toString();
                String password = et_password.getText().toString();
                String password_ok = et_password_ok.getText().toString();
                if (password.equals("")|| password_ok.equals("")){
                    Toast.makeText(ResetPassword.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                }else if (!password.equals(password_ok)){
                    Toast.makeText(ResetPassword.this,"密码不一致,请重新输入",Toast.LENGTH_SHORT).show();
                }else if (password.equals(password_ok)){
                    String msg = "手机号：" + phone;
                    JSONObject js_request = new JSONObject();
                    try {
                        js_request.put("account",phone);
                        js_request.put("password",password);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    //下面开始请求后台地址
                    RequestParams params = new RequestParams("http://47.100.175.180/nonjiyun/forgetPassword/" + phone);
                    params.setAsJsonContent(true);
                    params.setBodyContent(js_request.toString());
                    x.http().request(HttpMethod.PUT,params, new Callback.CommonCallback<String>() {
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

                        @Override
                        public void onSuccess(String arg0) {
                            System.out.println(arg0);
                            Toast.makeText(ResetPassword.this, arg0, Toast.LENGTH_SHORT).show();
                            int status=0;
                            try {
                                //服务器返回的是一个json封装的字符串，将其转换为json对象
                                JSONObject jsonObject = new JSONObject(arg0);
                                status = jsonObject.getInt("status");
                                if (status==1){
                                    Toast.makeText(ResetPassword.this,"密码修改成功",Toast.LENGTH_SHORT).show();
                                    Intent intent1=new Intent(ResetPassword.this,Activity_login.class);
                                    intent1.putExtra("phone",phone);
                                    startActivity(intent1);
                                    finish();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }

            }
            });
    }
}

