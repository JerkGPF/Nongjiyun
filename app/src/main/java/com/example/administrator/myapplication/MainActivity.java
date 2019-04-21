package com.example.administrator.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.myapplication.fragment.AskFragment;
import com.example.administrator.myapplication.fragment.ExchangeFragment;
import com.example.administrator.myapplication.fragment.HomeFragment;
import com.example.administrator.myapplication.fragment.KnowledgeFragment;
import com.example.administrator.myapplication.fragment.MyFragment;

import static android.widget.RadioGroup.*;

public class MainActivity extends AppCompatActivity {
    private FrameLayout fragLayout;
    private RadioGroup rg_bottom_navigation;
    private RadioButton rg_bottom_navigation_home;
    private RadioButton rg_bottom_navigation_think;
    private RadioButton rg_bottom_navigation_ask;
    private RadioButton rg_bottom_navigation_ex;
    private RadioButton rg_bottom_navigation_my;
    private HomeFragment homeFragment;
    private KnowledgeFragment knowledgeFragment;
    private AskFragment askFragment;
    private ExchangeFragment exchangeFragment;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     //   this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
//        if (getSupportActionBar() != null){
//            getSupportActionBar().hide();
//        }
        rg_bottom_navigation=(RadioGroup)findViewById(R.id.rg_bottom_navigation);
        rg_bottom_navigation_home=(RadioButton)findViewById(R.id.rg_bottom_navigation_home);
        rg_bottom_navigation_think=(RadioButton)findViewById(R.id.rg_bottom_navigation_think);
        rg_bottom_navigation_ask=(RadioButton)findViewById(R.id.rg_bottom_navigation_ask);
        rg_bottom_navigation_ex=(RadioButton)findViewById(R.id.rg_bottom_navigation_ex);
        rg_bottom_navigation_my=(RadioButton)findViewById(R.id.rg_bottom_navigation_my);
        fragLayout=(FrameLayout)findViewById(R.id.fraglayout);

         rg_bottom_navigation_home.setChecked(true);
         FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
         homeFragment=new HomeFragment();
        ft.add(R.id.fraglayout,homeFragment);
         ft.commit();
        rg_bottom_navigation.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                   switch (i){
                    case R.id.rg_bottom_navigation_home:
                        if (homeFragment==null){
                            homeFragment=new HomeFragment();
                        }
                        ChangeFragment(homeFragment);
                        break;
                    case R.id.rg_bottom_navigation_think:
                        if (knowledgeFragment==null){
                            knowledgeFragment=new KnowledgeFragment();
                        }
                        ChangeFragment(knowledgeFragment);
                        break;
                    case R.id.rg_bottom_navigation_ask:
                        if (askFragment==null)
                        {
                            askFragment=new AskFragment();
                        }
                        ChangeFragment(askFragment);
                        break;
                    case R.id.rg_bottom_navigation_ex:
                        if (exchangeFragment==null){
                            exchangeFragment=new ExchangeFragment();
                        }
                        ChangeFragment(exchangeFragment);
                        break;
                    case R.id.rg_bottom_navigation_my:
                        if (myFragment==null){
                            myFragment=new MyFragment();
                        }
                        ChangeFragment(myFragment);
                        break;
                   }
            }
            private void ChangeFragment(Fragment fragment) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fraglayout,fragment);
                ft.commit();
            }
        });

    }
}
