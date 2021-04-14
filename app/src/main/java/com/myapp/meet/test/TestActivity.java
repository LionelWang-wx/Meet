package com.myapp.meet.test;

import android.os.Bundle;
import android.widget.Toast;

import com.myapp.framework.manager.DialogManager;
import com.myapp.framework.view.DialogView;
import com.myapp.framework.view.TouchPictureView;
import com.myapp.meet.R;

import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {

    TouchPictureView tv_pictrue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test);
        DialogView dialogView = DialogManager.getInstance().initView(this, R.layout.activity_test);
        DialogManager.getInstance().show(dialogView);
        TouchPictureView tv_pictrue = dialogView.findViewById(R.id.tv_pictrue);
//        tv_pictrue = this.findViewById(R.id.tv_pictrue);
        tv_pictrue.setOnViewResultListener(result -> {
            if (result) {
                DialogManager.getInstance().hide(dialogView);
                Toast.makeText(TestActivity.this, "验证成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(TestActivity.this, "验证失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}