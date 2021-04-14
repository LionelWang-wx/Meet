package com.myapp.framework.base;

import android.content.Context;

import com.myapp.framework.bmob.BmobManager;
import com.myapp.framework.utils.SpUtils;

public class FrameWork {
    //volatile关键字可以防止jvm指令重排优化
    private volatile static FrameWork frameWork = null;

    public FrameWork() {

    }

    //双重校验锁实现单例模式
    public static FrameWork getInstance() {
        if (frameWork == null) {
            synchronized (FrameWork.class) {
                if (frameWork == null) {
                    frameWork = new FrameWork();
                }
            }
        }
        return frameWork;
    }

    public void initFrameWork(Context context) {
        SpUtils.getInstance().initSp(context);
        //Bmob初始化(Bmob相关功能必须初始化后才能使用)
        BmobManager.getInstance().initBmob(context);
    }

}
