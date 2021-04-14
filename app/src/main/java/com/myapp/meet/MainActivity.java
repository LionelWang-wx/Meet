package com.myapp.meet;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myapp.framework.view.DialogView;
import com.myapp.meet.base.BaseActivity;
import com.myapp.meet.fragment.ChatFragment;
import com.myapp.meet.fragment.MeFragment;
import com.myapp.meet.fragment.SquareFragment;
import com.myapp.meet.fragment.StarFragment;

import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    //星球
    private ImageView iv_star;
    private TextView tv_star;
    private LinearLayout ll_star;
    private StarFragment mStarFragment = null;
    private FragmentTransaction mStarTransaction = null;

    //广场
    private ImageView iv_square;
    private TextView tv_square;
    private LinearLayout ll_square;
    private SquareFragment mSquareFragment = null;
    private FragmentTransaction mSquareTransaction = null;

    //聊天
    private ImageView iv_chat;
    private TextView tv_chat;
    private LinearLayout ll_chat;
    private ChatFragment mChatFragment = null;
    private FragmentTransaction mChatTransaction = null;

    //我的
    private ImageView iv_me;
    private TextView tv_me;
    private LinearLayout ll_me;
    private MeFragment mMeFragment = null;
    private FragmentTransaction mMeTransaction = null;

//  private Disposable disposable;
    /**
     * 1.初始化Frahment
     * 2.显示Fragment
     * 3.隐藏所有的Fragment
     * 4.恢复Fragment
     * 优化的手段
     */

    private DialogView mUploadView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        //设置文本
        tv_star.setText(getString(R.string.text_main_star));
        tv_square.setText(getString(R.string.text_main_square));
        tv_chat.setText(getString(R.string.text_main_chat));
        tv_me.setText(getString(R.string.text_main_me));
    }

    private void initView() {


        iv_star = this.findViewById(R.id.iv_star);
        tv_star = this.findViewById(R.id.tv_star);
        ll_star = this.findViewById(R.id.ll_star);

        iv_square = this.findViewById(R.id.iv_square);
        tv_square = this.findViewById(R.id.tv_square);
        ll_square = this.findViewById(R.id.ll_square);

        iv_chat = this.findViewById(R.id.iv_chat);
        tv_chat = this.findViewById(R.id.tv_chat);
        ll_chat = this.findViewById(R.id.ll_chat);

        iv_me = this.findViewById(R.id.iv_me);
        tv_me = this.findViewById(R.id.tv_me);
        ll_me = this.findViewById(R.id.ll_me);

        ll_star.setOnClickListener(this);
        ll_square.setOnClickListener(this);
        ll_chat.setOnClickListener(this);
        ll_me.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.ll_star:
//
//                break;
//            case R.id.ll_star:
//
//                break;
//            case R.id.ll_star:
//
//                break;
//            case R.id.ll_star:
//
//                break;
//            case R.id.ll_star:
//
//                break;

        }
    }
}