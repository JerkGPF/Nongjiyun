package com.example.administrator.myapplication.utils;

import android.app.Application;

import org.xutils.x;

public class App extends Application {
 
        @Override
        public void onCreate() {
                // TODO Auto-generated method stub
                super.onCreate();
                x.Ext.init(this);
        }
}