package com.myapp.meet.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

import com.myapp.framework.base.FrameWork;
import com.myapp.framework.bmob.BmobManager;
import com.myapp.framework.entity.Constants;
import com.myapp.framework.utils.SpUtils;
import com.myapp.meet.MainActivity;
import com.myapp.meet.R;
import com.myapp.meet.base.BaseActivity;

import androidx.annotation.NonNull;


/**
 * 启动页
 */
public class IndexActivity extends BaseActivity {


    private static final int SKIP_MAIN = 1000;
    private Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SKIP_MAIN:
                    startMain();
                    break;
            }
        }


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        //初始化Bmob
        FrameWork.getInstance().initFrameWork(this);
        handler.sendEmptyMessageDelayed(SKIP_MAIN, 2000);


    }

    //
    private void startMain() {
        //1.判断app是否第一次启动
        Intent intent = new Intent();
//        boolean isFirstApp = false;
//        String token="";
//        try {
        boolean isFirstApp = SpUtils.getInstance().getBoolean(Constants.SP_IS_FIRST_APP, true);
        String token = SpUtils.getInstance().getString(Constants.SP_TOKEN, "");
//        }catch (NullPointerException e){
//            e.printStackTrace();
//        }
        if (isFirstApp) {
            //跳转引导页
            intent.setClass(this, GuideActivity.class);
            //改变Constants.SP_IS_FIRST_APP的值
            SpUtils.getInstance().putBoolean(Constants.SP_IS_FIRST_APP, false);
        } else {
            //判断曾经是否登录过
            if (TextUtils.isEmpty(token)) {
                //判断Bmob是否登录
                if (BmobManager.getInstance().isLogin()) {
                    //跳转主页
                    intent.setClass(this, MainActivity.class);
                } else {
                    //跳转登录页
                    intent.setClass(this, LoginActivity.class);
                }
            } else {
                //跳转主页
                intent.setClass(this, MainActivity.class);
            }
        }
        startActivity(intent);
        finish();
    }
}