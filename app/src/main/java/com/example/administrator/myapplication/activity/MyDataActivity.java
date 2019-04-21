package com.example.administrator.myapplication.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.utils.JsonBean;
import com.example.administrator.myapplication.utils.JsonFileReader;
import com.example.administrator.myapplication.utils.PhotoUtils;
import com.example.administrator.myapplication.utils.ToastUtils;
import com.example.administrator.myapplication.utils.UserMessage;
import com.google.gson.Gson;
import com.lidroid.xutils.ViewUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;
import org.json.JSONArray;
import java.util.ArrayList;


public class MyDataActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MyDataActivity";
    @ViewInject(R.id.iv_photo)
    private CircleImageView iv_photo;
    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    private static final int CAMERA_PERMISSIONS_REQUEST_CODE = 0x03;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    private File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/photo.jpg");
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri imageUri;
    private Uri cropImageUri;
    private ImageView mydata_back_bt;


    private  TextView tv_type;
    private TextView mydata_save_tv;
    private LinearLayout line_mydata_id;
    private TextView tv_nickname;
    private TextView tv_phone;
    private TextView tv_adress;
    private TextView  tv_company;
    private TextView  tv_education;
    private TextView tv_sex;
    private TextView tv_email;
    private TextView tv_01;
    private LinearLayout line_mydata_name;
    private LinearLayout line_mydata_head;
    private LinearLayout line_mydata_sex;
    private LinearLayout line_mydata_address;
    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        initView();//三级联动
        initJsonData();//三级联动
        //初始化请求对象
        x.view().inject(this);
        ViewUtils.inject(this);

        mydata_back_bt=(ImageView)findViewById(R.id.mydata_back_bt);
        tv_nickname=(TextView)findViewById(R.id.tv_nickname);
        tv_phone=(TextView)findViewById(R.id.tv_phone);
        tv_type=(TextView)findViewById(R.id.tv_type);
         tv_adress=(TextView)findViewById(R.id.tv_adress);
        line_mydata_id=(LinearLayout)findViewById(R.id.line_mydata_id);
        mydata_save_tv=(TextView)findViewById(R.id.mydata_save_tv);
        tv_company=(TextView)findViewById(R.id.tv_company);
        tv_education=(TextView)findViewById(R.id.tv_education);
        tv_sex=(TextView)findViewById(R.id.tv_sex);
        tv_email=(TextView)findViewById(R.id.tv_email);
        tv_01=(TextView)findViewById(R.id.tv_01);
        line_mydata_name=(LinearLayout)findViewById(R.id.line_mydata_name);
        line_mydata_head =(LinearLayout)findViewById(R.id.line_mydata_head);
        line_mydata_sex =(LinearLayout)findViewById(R.id.line_mydata_sex);
        line_mydata_address = (LinearLayout)findViewById(R.id.line_mydata_address);


        SharedPreferences sp=getSharedPreferences("admin", MODE_PRIVATE);
        tv_nickname.setText(sp.getString("nickname",""));
        tv_type.setText(sp.getString("role",""));
        tv_adress.setText(sp.getString("city",""));
        tv_phone.setText(sp.getString("account",""));
        tv_company.setText(sp.getString("organization_name",""));

        String ss =sp.getString("sex","");
        try {
            float option = Float.parseFloat(ss);
            if (option==1.0){
                tv_sex.setText("男");
            }else if (option==2.0){
                tv_sex.setText("女");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        tv_type.setOnClickListener(this);
        line_mydata_id.setOnClickListener(this);
        mydata_save_tv.setOnClickListener(this);
        line_mydata_name.setOnClickListener(this);
        tv_company.setOnClickListener(this);
        tv_01.setOnClickListener(this);
        mydata_back_bt.setOnClickListener(this);
        line_mydata_head.setOnClickListener(this);
        tv_nickname.setOnClickListener(this);
        line_mydata_sex.setOnClickListener(this);
        line_mydata_address.setOnClickListener(this);



//        line_mydata_id.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MyDataActivity.this,MyDateChooseType.class);
//                startActivityForResult(intent,1);
//            }
//        });

    }

    private static final int OUTPUT_X = 480;
    private static final int OUTPUT_Y = 480;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                //拍照完成回调
                case CODE_CAMERA_REQUEST:
                    cropImageUri = Uri.fromFile(fileCropUri);
                    PhotoUtils.cropImageUri(this, imageUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                    break;
                //访问相册完成回调
                case CODE_GALLERY_REQUEST:
                    if (hasSdcard()) {
                        cropImageUri = Uri.fromFile(fileCropUri);
                        Uri newUri = Uri.parse(PhotoUtils.getPath(this, data.getData()));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            newUri = FileProvider.getUriForFile(this, "com.gpf.fileprovider", new File(newUri.getPath()));
                        }
                        PhotoUtils.cropImageUri(this, newUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                    } else {
                        ToastUtils.showShort(this, "设备没有SD卡！");
                    }
                    break;
                case CODE_RESULT_REQUEST:
                    Bitmap bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, this);
                    if (bitmap != null) {
                        showImages(bitmap);
                    }
                    break;
                default:
            }
        }
        switch (resultCode){
            case 2:
                String kejiao=data.getStringExtra("choose1");
                tv_type.setText(kejiao);
                break;
            case 4:
                String newname=data.getStringExtra("newname");
                tv_nickname.setText(newname);
                break;
            case 6:
                String newcompany=data.getStringExtra("newcompany");
                tv_company.setText(newcompany);
                break;
            case 520:
                String expert=data.getStringExtra("choose2");
                tv_type.setText(expert);
                break;
            case 521:
                String putong=data.getStringExtra("choose4");
                tv_type.setText(putong);
                break;
        }

    }
    private void showImages(Bitmap bitmap) {
        iv_photo.setImageBitmap(bitmap);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            //调用系统相机申请拍照权限回调
            case CAMERA_PERMISSIONS_REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (hasSdcard()) {
                        imageUri = Uri.fromFile(fileUri);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                            imageUri = FileProvider.getUriForFile(MyDataActivity.this, "com.gpf.fileprovider", fileUri);//通过FileProvider创建一个content类型的Uri
                        PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
                    } else {
                        ToastUtils.showShort(this, "设备没有SD卡！");
                    }
                } else {

                    ToastUtils.showShort(this, "请允许打开相机！！");
                }
                break;


            }
            //调用系统相册申请Sdcard权限回调
            case STORAGE_PERMISSIONS_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
                } else {

                    ToastUtils.showShort(this, "请允许打操作SDCard！！");
                }
                break;
            default:
        }
    }

    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }


    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mydata_back_bt:
                finish();
                break;
            case R.id.line_mydata_id:
                Intent intent=new Intent(MyDataActivity.this,MyDateChooseType.class);
                 startActivityForResult(intent,1);
                 break;
            case R.id.line_mydata_head://图片选择及剪裁


                final Dialog picture_dialog = new Dialog(this);
                //去掉标题线
                picture_dialog.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
                View picture_contentView = LayoutInflater.from(this).inflate(R.layout.dialog_photo, null);
                picture_dialog.setContentView(picture_contentView);
                TextView photo=picture_contentView.findViewById(R.id.dialog_photo);
                TextView picture=picture_contentView.findViewById(R.id.dialog_picture);
                TextView photo_cancel = picture_contentView.findViewById(R.id.dialog_photo_cancel);

                photo_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        picture_dialog.dismiss();
                    }
                });
                picture.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoObtainStoragePermission();
                        picture_dialog.dismiss();
                    }
                    private void autoObtainStoragePermission() {
                        if (ContextCompat.checkSelfPermission(MyDataActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(MyDataActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
                        } else {
                            PhotoUtils.openPic(MyDataActivity.this, CODE_GALLERY_REQUEST);
                        }
                    }
                });

                photo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        autoObtainCameraPermission();
                        picture_dialog.dismiss();
                    }
                    /**
                     * 自动获取相机权限
                     */
                    private void autoObtainCameraPermission() {
                        if (ContextCompat.checkSelfPermission(MyDataActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                                || ContextCompat.checkSelfPermission(MyDataActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                            if (ActivityCompat.shouldShowRequestPermissionRationale(MyDataActivity.this, Manifest.permission.CAMERA)) {
                                ToastUtils.showShort(MyDataActivity.this, "您已经拒绝过一次");
                            }
                            ActivityCompat.requestPermissions(MyDataActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, CAMERA_PERMISSIONS_REQUEST_CODE);
                        } else {//有权限直接调用系统相机拍照
                            if (hasSdcard()) {
                                imageUri = Uri.fromFile(fileUri);
                                //通过FileProvider创建一个content类型的Uri
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    imageUri = FileProvider.getUriForFile(MyDataActivity.this, "com.gpf.fileprovider", fileUri);
                                }
                                PhotoUtils.takePicture(MyDataActivity.this, imageUri, CODE_CAMERA_REQUEST);
                            } else {
                                ToastUtils.showShort(MyDataActivity.this, "设备没有SD卡！");
                            }
                        }
                    }
                });
                //背景透明
                picture_dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                picture_dialog.show();
                Window windows = picture_dialog.getWindow();
                WindowManager.LayoutParams lps = windows.getAttributes();
                lps.gravity = Gravity.BOTTOM; // 底部
                lps.width = WindowManager.LayoutParams.MATCH_PARENT;
                lps.height = WindowManager.LayoutParams.WRAP_CONTENT;
                windows.setAttributes(lps);
                windows.setWindowAnimations(R.style.mystyle);  //添加动画
                picture_dialog.setCanceledOnTouchOutside(true);
                break;


            case R.id.line_mydata_sex://性别选择对话框弹出
                final Dialog dialog = new Dialog(this);
                //去掉标题线
                dialog.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
                View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_sex, null);
                dialog.setContentView(contentView);
                TextView man=contentView.findViewById(R.id.dialog_man);
                TextView woman=contentView.findViewById(R.id.dialog_woman);
                TextView cancel = contentView.findViewById(R.id.dialog_cancel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                woman.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tv_sex.setText("女");
                        dialog.dismiss();
                    }
                });
                man.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tv_sex.setText("男");
                        dialog.dismiss();
                    }
                });
                //背景透明
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.show();
                Window window = dialog.getWindow();
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.gravity = Gravity.BOTTOM; // 底部
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                window.setAttributes(lp);
                window.setWindowAnimations(R.style.mystyle);  //添加动画
                dialog.setCanceledOnTouchOutside(true);
                break;

            case R.id.tv_01://行业类别
                Intent it=new Intent(MyDataActivity.this, QuestionTypeActivity.class);
                startActivity(it);
                break;


            case R.id.mydata_save_tv:

              //  String phone=tv_phone.getText().toString();
                String type=tv_type.getText().toString();

                String name=tv_nickname.getText().toString();
                String tv1=tv_01.getText().toString();
                String company=tv_company.getText().toString();
                String education=tv_education.getText().toString();
                sex=tv_sex.getText().toString();
                sex=tv_sex.getText().toString();
                int log=0;
                if (sex.equals("男")){
                    log = 1;
                }else if (sex.equals("女")){
                    log = 2;
                }
                String email=tv_email.getText().toString();
                String adress=tv_adress.getText().toString();
                SharedPreferences sp=getSharedPreferences("admin",MODE_PRIVATE);

                String dis=sp.getString("district","");
                String del_flag=sp.getString("del_flag","");
                String status=sp.getString("status","");
                String create_time=sp.getString("create_time","");






//
//                String msg="行业类型："+tv1+",姓名："+name+",单位名称："+company+",身份:"+type+",学历："
//                        +education+",地址:"+adress+",性别:"+sex+",邮箱:"+email;
                JSONObject js_request = new JSONObject();
                try {
                    js_request.put("account",sp.getString("account",""));
                    js_request.put("role",type);
                    js_request.put("nickname",name);
                    js_request.put("avatar",sp.getString("avatar",""));
                    js_request.put("organization_name",company);
                   //根据实际需求添加相应键值对
                    js_request.put("education",education);
                    js_request.put("sex",log );
                    js_request.put("email",email);
                    js_request.put("city",adress);
                    js_request.put("district",sp.getString("district",""));
                    js_request.put("del_flag",sp.getString("del_flag",""));
                    js_request.put("status",sp.getString("status",""));

              //      js_request.put("create_time",sp.getString("create_time",sp.getString("create_time","")));
                    //js_request.put("update_time",sp.getString("update_time",""));

//                    js_request.put("sort_time",sp.getString("sort_time",""));
//                    js_request.put("info_complete",sp.getString("info_complete",""));

                } catch (JSONException e) {
                    e.printStackTrace();

                }

               // SharedPreferences sp= getSharedPreferences("admin",MODE_PRIVATE);
                final String username=sp.getString("account","");


                //下面开始请求后台地址
                RequestParams params = new RequestParams("http://47.100.175.180/nonjiyun/updateUser_info/"+username);
                params.setAsJsonContent(true);
                params.setBodyContent(js_request.toString());

                x.http().request(HttpMethod.PUT,params,new Callback.CommonCallback<String>() {
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

         //请求成功方法 arg0为返回的数据
                            Toast.makeText(MyDataActivity.this,  arg0, Toast.LENGTH_LONG).show();
                            System.out.println(arg0);
                            int status = 0;
                            try {
                            //服务器返回的是一个json封装的字符串，将其转换为json对象
                                JSONObject jsonObject =  new JSONObject(arg0);
                                status = jsonObject.getInt("status");


                            //  Toast.makeText(x.app(),""+status,Toast.LENGTH_SHORT).show();
                            //如果状态码正确，这里得到

                                if(status==3){
                                    JSONObject object =jsonObject.getJSONObject("data");
                                    UserMessage user =new Gson().fromJson(object.toString(),UserMessage.class);
                                    SharedPreferences.Editor editor = getSharedPreferences("admin",MODE_PRIVATE).edit();
                                    editor.putString("nickname",user.getNickname());
                                    editor.putString("role", (String)user.getRole());
                                    editor.putString("sex", ""+user.getSex());
                                    editor.putString("avatar",""+user.getAvatar());
                                    editor.putString("organization_name", (String) user.getOrganization_name());
                                    editor.putString("city",user.getCity());
                                    editor.apply();
//
//                                Intent intent = new Intent(RegisterInfoActivity.this,Activity_login.class);
//                                intent.putExtra("view",reister_info_phone.getText().toString());
//                                startActivity(intent);
                                Toast.makeText(MyDataActivity.this,"个人信息修改成功",Toast.LENGTH_SHORT).show();
                                finish();

                            } else if(status==2){

                                Toast.makeText(x.app(),"个人信息修改失败",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                });
              break;
            case R.id.line_mydata_address://三级联动
                showPickerView();
                break;


            case R.id.line_mydata_name:
                Intent intent1=new Intent(MyDataActivity.this,MyDataNickname.class);
                startActivityForResult(intent1,3);
                break;
            case R.id.tv_company:
                Intent intent2=new Intent(MyDataActivity.this,MyDataCompany.class);
                startActivityForResult(intent2,5);
                break;
        }
    }

    private void showPickerView() {
        OptionsPickerView pvOptions=new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String text = options1Items.get(options1).getPickerViewText() +
                        options2Items.get(options1).get(options2) +
                        options3Items.get(options1).get(options2).get(options3);
                tv_adress.setText(text);
            }
        }).setTitleText("")
                .setDividerColor(Color.GRAY)
                .setTextColorCenter(Color.GRAY)
                .setContentTextSize(13)
                .setOutSideCancelable(false)
                .build();
          /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();
    }

    private void initView() {
        tv_adress = (TextView) findViewById(R.id.tv_adress);
    }


    private void initJsonData() {   //解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        //  获取json数据
        String JsonData = JsonFileReader.getJson(this, "province_data.json");
        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市

                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {

                    for (int d = 0; d < jsonBean.get(i).getCityList().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = jsonBean.get(i).getCityList().get(c).getArea().get(d);

                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }
    }

    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }
}
