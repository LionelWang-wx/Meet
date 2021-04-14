package com.myapp.meet.base;

import android.app.Application;

import com.myapp.framework.base.FrameWork;

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Bmob
        FrameWork.getInstance().initFrameWork(this);
    }
}
