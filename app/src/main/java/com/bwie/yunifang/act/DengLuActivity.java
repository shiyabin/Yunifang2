package com.bwie.yunifang.act;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.yunifang.R;

public class DengLuActivity extends AppCompatActivity {

    private ImageView login_image;
    private TextView tv_login;
    private TextView tv_sjdl;
    private TextView tv_ynfdl;
    private Button button1;
    private LinearLayout buju_shouji;
    private EditText ed_mima;
    private TextView tv_wjmm;
    private ImageView qq;
    private ImageView weixin;
    private ImageView weibo;
    private ImageView imag_fanhui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deng_lu);
        initView();
    }
    private void initView() {
        imag_fanhui = (ImageView) findViewById(R.id.imag_fanhui);
        login_image=(ImageView) findViewById(R.id.login_image);
        tv_login=(TextView) findViewById(R.id.tv_login);
        tv_sjdl=(TextView) findViewById(R.id.tv_sjdl);
        tv_ynfdl=(TextView) findViewById(R.id.tv_ynfdl);
        button1=(Button) findViewById(R.id.button1);
        buju_shouji=(LinearLayout) findViewById(R.id.buju_shouji);
        ed_mima=(EditText) findViewById(R.id.ed_mima);
        tv_wjmm=(TextView) findViewById(R.id.tv_wjmm);

    }
}
