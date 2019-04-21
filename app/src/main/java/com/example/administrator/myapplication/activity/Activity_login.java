package com.example.administrator.myapplication.activity;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.myapplication.MainActivity;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.fragment.HomeEditSearch;
import com.example.administrator.myapplication.fragment.HomeFragment;
import com.example.administrator.myapplication.fragment.Home_Details;
import com.example.administrator.myapplication.fragment.MyFragment;
import com.example.administrator.myapplication.utils.TelNumMatch;
import com.example.administrator.myapplication.utils.UserMessage;
import com.example.administrator.myapplication.view.CustomToastView;
import com.example.administrator.myapplication.view.RefuseToastView;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2018/5/2.
 */

public class Activity_login extends AppCompatActivity   {
    private static final String TAG = "Activity_login";
    private static final String APP_ID = "1106831363";//官方获取的APPID
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;


    private Button login_iv_back;

    private Button button;
    private TextView tv_fpassward;
    private TextView tv_forget;
    private Button bt_reister;
    private Button login_back;
    private EditText phone;
    private EditText password;
    private Button bt_login;
    private Button register;
    static CustomToastView customToastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //传入参数APPID和全局Context上下文
        mTencent = Tencent.createInstance(APP_ID,Activity_login.this.getApplicationContext());
        //初始化请求对象
        x.view().inject(this);
        init();
        login_iv_back =(Button)findViewById(R.id.login_iv_back);
        login_iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    switch (resultCode){
//        case 520:
//            String number=data.getStringExtra("view");
//            phone.setText(number);
//    }
//    }

    //微信跳转至会话列表
    public void chatLogin(View v){

        Intent intent =new Intent(Activity_login.this, HuiHuaActivity.class);
        startActivity(intent);
    }

    public void qqLogin(View v){
        /**通过这句代码，SDK实现了QQ的登录，这个方法有三个参数，第一个参数是context上下文，第二个参数SCOPO 是一个String类型的字符串，表示一些权限
         官方文档中的说明：应用需要获得哪些API的权限，由“，”分隔。例如：SCOPE = “get_user_info,add_t”；所有权限用“all”
         第三个参数，是一个事件监听器，IUiListener接口的实例，这里用的是该接口的实现类 */
        mIUiListener = new BaseUiListener();
        //all表示获取所有权限
        mTencent.login(Activity_login.this,"all", mIUiListener);
    }

    /**
     * 自定义监听器实现IUiListener接口后，需要实现的3个方法
     * onComplete完成 onError错误 onCancel取消
     */
    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            Toast.makeText(Activity_login.this, "授权成功", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken,expires);
                QQToken qqToken = mTencent.getQQToken();
                mUserInfo = new UserInfo(getApplicationContext(),qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e("zzz","登录成功"+response.toString());
                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG,"登录失败"+uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG,"登录取消");

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(Activity_login.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(Activity_login.this, "授权取消", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * 在调用Login的Activity或者Fragment中重写onActivityResult方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.REQUEST_LOGIN){
            Tencent.onActivityResultData(requestCode,resultCode,data,mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }




    private void init() {
        phone=(EditText)findViewById(R.id.et_phone);
        password=(EditText)findViewById(R.id.et_password);
        bt_login=(Button)findViewById(R.id.bt_login);
        register=(Button)findViewById(R.id.reister);
        button = (Button)findViewById(R.id.login_iv_back);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //忘记密码
        tv_forget = (TextView)findViewById(R.id.tv_fpassward);

        final Intent intent=getIntent();
        String date=intent.getStringExtra("view");
        phone.setText(date);

        //重置密码，接收返回值
        Intent intent1=getIntent();
        String phonenumber=intent1.getStringExtra("phone");
        phone.setText(phonenumber);

        tv_forget.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_login.this,ForgetPassActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //注册
        bt_reister = (Button)findViewById(R.id.reister);
        bt_reister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_login.this,ReisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //登录
        bt_login=(Button)findViewById(R.id.bt_login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_login.this,ReisterActivity.class);
                startActivity(intent);
            }
        });
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View agr0) {
                final String name = phone.getText().toString();//获取用户名
                String pass = password.getText().toString();//获取输入的密码
                long timeStamp = System.currentTimeMillis();



                String userPhoneNumber = phone.getText().toString();
                if (phone.length() == 0) {
                    Toast refuseToast = new Toast(Activity_login.this.getApplicationContext());
                    //view布局
                    View refuseView = LayoutInflater.from(Activity_login.this.getApplicationContext()).inflate(R.layout.refuse_toast_view, null, false);
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
                    }
                    else if (!TelNumMatch.isValidPhoneNumber(userPhoneNumber)) {
                    Toast refuseToast = new Toast(Activity_login.this.getApplicationContext());
                    //view布局
                    View refuseView = LayoutInflater.from(Activity_login.this.getApplicationContext()).inflate(R.layout.refuse_toast_view, null, false);
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
                }
                else if (pass.length() <= 0) {
                    Toast.makeText(Activity_login.this, "密码不能为空", Toast.LENGTH_SHORT).show();

                }
                else if (pass.length() < 6 || pass.length() > 15) {
                    Toast.makeText(Activity_login.this, "密码长度不能小于6或者大于15", Toast.LENGTH_SHORT).show();
                }
      //          String msg = "用户名：" + name + ",密码：" + pass;
                JSONObject js_request = new JSONObject();//服务器需要传参的json对象
                try {
                    js_request.put("account",name);//根据实际需求添加相应键值对
                    js_request.put("password",pass);
                    js_request.put("login_time",timeStamp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //下面开始请求后台地址
                RequestParams params = new RequestParams("http://47.100.175.180/nonjiyun/sign");
                params.setAsJsonContent(true);
                params.setBodyContent(js_request.toString());
              //  params.addBodyParameter("", "{\"account\": \"" + name + "\",\"password\": \"" + pass + "\"}");

                x.http().post(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onCancelled(CancelledException arg0) {

                    }


                    @Override
                    public void onError(Throwable arg0, boolean arg1) {
                        // TODO Auto-generated method stub
                        Toast.makeText(Activity_login.this, "登录失败", Toast.LENGTH_SHORT).show();
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
                        int status = 0;
                        try {
                            //服务器返回的是一个json封装的字符串，将其转换为json对象
                            JSONObject jsonObject = new JSONObject(arg0);
                            status = jsonObject.getInt("status");


                            if (status == 2) {

                                JSONObject object = jsonObject.getJSONObject("data");
                                JSONObject userobject =object.getJSONObject("user_info");
                                UserMessage user = new Gson().fromJson(userobject.toString(), UserMessage.class);
                                SharedPreferences.Editor editor = getSharedPreferences("admin", MODE_PRIVATE).edit();
                                editor.putInt("user_info_id", user.getUser_info_id());
                                editor.putString("account", user.getAccount());
                                editor.putString("role", user.getRole());
                                editor.putString("nickname", user.getNickname());
                                editor.putString("avatar", (String) user.getAvatar());
                                editor.putString("organization_name", (String) user.getOrganization_name());
                                editor.putString("education", (String) user.getEducation());
                                editor.putString("sex",""+ user.getSex());
                                editor.putString("email", (String) user.getEmail());
                                editor.putString("city",user.getCity());
                                editor.putString("district",user.getDistrit());
                                editor.putString("del_flag", String.valueOf(user.getDel_flag()));
                                editor.putString("status", String.valueOf(user.getStatus()));
                                editor.putString("create_time", (String) user.getCreate_time());
                                editor.putString("update_time", String.valueOf(user.getUpdate_time()));
                                editor.putString("sort_time", (String) user.getSort_time());
                                editor.putString("info_complete", String.valueOf(user.getInfo_complete()));
                                editor.apply();
                                finish();
                                Toast smileToast=new Toast(Activity_login.this.getApplicationContext());
                                //view布局
                                View smileView = LayoutInflater.from(Activity_login.this.getApplicationContext()).inflate(R.layout.knowledge_smile_toast,null,false);
                                TextView text = (TextView) smileView.findViewById(R.id.toastMessage);
                                text.setText("登录成功");
                                //给customToastView增加动画效果
                                customToastView=(CustomToastView) smileView.findViewById(R.id.smileView);
                                customToastView.startAnim();
                                text.setBackgroundResource(R.drawable.shape_knowledge_toast_text);
                                text.setTextColor(Color.parseColor("#FFFFFF"));
                                smileToast.setView(smileView);
                                smileToast.setDuration(Toast.LENGTH_SHORT);
                                smileToast.show();
                            } else if (status == 04) {
                                Toast.makeText(x.app(), "账号或密码错误", Toast.LENGTH_SHORT).show();
                            } else if (status == 05) {
                                Toast.makeText(x.app(), "账号不存在", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                });
            }

        });
    }

}
