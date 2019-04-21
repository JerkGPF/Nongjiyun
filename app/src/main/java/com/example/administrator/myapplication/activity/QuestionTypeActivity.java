package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.QuestionTypeAdapter;
import com.example.administrator.myapplication.moduels.QuestionType;

import java.util.ArrayList;

public class QuestionTypeActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView listView;
    private QuestionTypeAdapter questionTypeAdapter;
    private QuestionTypeAdapter questionTypeAdapter2;
    private ArrayList<QuestionType> arrayList;
    private ArrayList<QuestionType> arrayList2;
    private Button back;
    private TextView tv_question_title;
    private TextView tv_question_gain;
    private ListView lv_question_type2;
    private TextView tv_question_ensure;
    private LinearLayout ly_question_third;
    private EditText et_question_first;
    private EditText et_question_second;
    private final static String question_gain = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_type);
        arrayList =new ArrayList<>();
        arrayList2 =new ArrayList<>();
        listView=findViewById(R.id.lv_question_type);
        back=findViewById(R.id.btn_type_back);
        tv_question_title=findViewById(R.id.tv_question_title);
        tv_question_gain=findViewById(R.id.tv_question_gain);
        lv_question_type2=findViewById(R.id.lv_question_type2);
        tv_question_ensure=findViewById(R.id.tv_question_ensure);
        ly_question_third=findViewById(R.id.ly_question_third);
        et_question_first=findViewById(R.id.et_question_first);
        et_question_second=findViewById(R.id.et_question_second);
        back.setOnClickListener(this);
        questionTypeAdapter=new QuestionTypeAdapter(QuestionTypeActivity.this,arrayList);
        listView.setAdapter(questionTypeAdapter);
        initQuestionType();


        tv_question_title.setText("选择行业类别");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView title =view.findViewById(R.id.tv_type);
                final String title2= title.getText().toString();
                if(title2!=null) {
                    // 获取值传递到隐藏的TextView
                    tv_question_title.setText("选择种养类别");
                    tv_question_gain.setVisibility(View.VISIBLE);
                    tv_question_gain.setText(title2);
                    listView.setVisibility(View.GONE);
                    lv_question_type2.setVisibility(View.VISIBLE);
                    questionTypeAdapter2=new QuestionTypeAdapter(QuestionTypeActivity.this,arrayList2);
                    lv_question_type2.setAdapter(questionTypeAdapter2);
                    initQuestionType2();

                    //实现选择行业二级条三级的功能
                    lv_question_type2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            TextView title =view.findViewById(R.id.tv_type);
                            final String title3= title.getText().toString();
                            tv_question_title.setText("确定规模");
                            tv_question_ensure.setVisibility(View.VISIBLE);
                            tv_question_title.setText("输入规模");
                            if(title3!=null){
                                String question_gain=title2+">"+title3;
                                tv_question_gain.setVisibility(View.VISIBLE);
                                tv_question_gain.setText(question_gain);
                                lv_question_type2.setVisibility(View.GONE);
                                ly_question_third.setVisibility(View.VISIBLE);
                                tv_question_ensure.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent =new Intent(QuestionTypeActivity.this,MyDataActivity.class);
                                        String first=et_question_first.getText().toString();
                                        String second=et_question_second.getText().toString();
                                        String sum=title2+title3+first+" ~ "+second+"亩";
                                        intent.putExtra("num",sum);
                                        setResult(2,intent);
                                        finish();
                                    }
                                });
                            }


                        }
                    });


                }



            }
        });

    }

    private void initQuestionType() {
        arrayList.add(new QuestionType("粮经"));
        arrayList.add(new QuestionType("园艺"));
        arrayList.add(new QuestionType("禽牧"));
        arrayList.add(new QuestionType("水产"));
        arrayList.add(new QuestionType("综合"));
        arrayList.add(new QuestionType("农机"));
        arrayList.add(new QuestionType("其他"));
    }
    private void initQuestionType2() {
        arrayList2.add(new QuestionType("大豆"));
        arrayList2.add(new QuestionType("玉米"));
        arrayList2.add(new QuestionType("水稻"));
        arrayList2.add(new QuestionType("棉花"));
        arrayList2.add(new QuestionType("油菜"));
        arrayList2.add(new QuestionType("大麦"));
        arrayList2.add(new QuestionType("花生"));
        arrayList2.add(new QuestionType("小麦"));
        arrayList2.add(new QuestionType("甘薯"));
        arrayList2.add(new QuestionType("蚕桑"));
        arrayList2.add(new QuestionType("其他"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_type_back:
                finish();
                break;


        }
    }
}
