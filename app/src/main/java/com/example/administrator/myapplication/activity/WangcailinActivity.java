package com.example.administrator.myapplication.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.utils.DataCleanManager;

public class WangcailinActivity extends AppCompatActivity {
    private ImageView into;
    private ImageView wangcailin_back_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wangcailin);
        ImageView wangcailin_back_iv=(ImageView)findViewById(R.id.wangcailin_back_iv);
        wangcailin_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageView into=(ImageView)findViewById(R.id.wangcailin_iv_into);
        into.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogdetail();
            }
            private void Dialogdetail() {
                String yes = "<font color='#2EC667'>" + "确定" + "</font>";
                AlertDialog dialog = new AlertDialog.Builder(WangcailinActivity.this)
                        .setMessage("1982年1月毕业于原江苏农学院苏州地区专科班农学专业。" +
                                "1997年3月至1999年3月作为日本学术振兴会的特别研究员，赴日本宫崎大学从事博士后研究。" +
                                "现任粮食作物研究所所长、研究员，兼任国家水稻产业技术体系执行专家组成员、" +
                                "江苏省水稻攻关协作组首席专家、江苏省优质水稻工程技术研究中心主任、" +
                                "江苏省农作物品种审定委员会水稻专业委员会委员、" +
                                "中国作物学会水稻专业委员会理事、江苏省遗传学会理事会副秘书长、" +
                                "江苏省种子协会理事，南京农业大学博士生导师，扬州大学兼职教授，" +
                                "江苏省农业科学院博士后工作站导师。王才林同志长期从事水稻遗传育种研究，" +
                                "先后参加杂交粳稻国家攻关、省攻关和国家863等项目，主持并完成国家自然科学基金、" +
                                "农业部“948”、“973”、跨越计划、水稻综合生产能力科技提升行动计划、" +
                                "农业结构调整重大技术研究专项、省高技术研究、省自然科学基金、省应用基础研究、" +
                                "国际合作、回国人员基金等项目，多次赴日本进行合作研究。现主持国家“863”、“948”、" +
                                "科技支撑计划、行业科技专项、超级稻育种与示范、跨越计划、转基因专项等重大项目研究。" +
                                "主持育成抗条纹叶枯病优质高产粳稻新品种“南粳44”、优良食味水稻新品种“南粳46”、" +
                                "“南粳5055”、杂交粳稻“95优161” 和BT型粳稻不育系“95122A”通过审定。" +
                                "育成抗除草剂等转基因水稻新品系多个。作为主要完成人获得国家科技进步一等奖1项、" +
                                "发明二等奖1项、农业部科技进步二等奖1项、教育部科技进步一等奖1项、省科技进步一等奖2项、" +
                                "二等奖1项、省农业技术推广一等奖1项、中国发明专利优秀奖1项、国家发明专利7项、新品种权14项，" +
                                "申请国家发明专利4项、新品种权11项，在国内外核心期刊发表论文200多篇，主编著作3部。" +
                                "2008年获得江苏省有突出贡献中青年专家称号，2009年被评为江苏省农科院优秀共产党员，" +
                                "2010年获得南京农业大学优秀研究生导师称号，2011年被评为江苏省先进工作者。")//设置对话框的内容
                        //设置对话框的按钮
                        .setNegativeButton(Html.fromHtml(yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
            }
        });
    }
}
