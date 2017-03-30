package com.bwie.yunifang.act;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwie.yunifang.R;
import com.bwie.yunifang.utils.CommonJieXi;
import com.youth.banner.Banner;

public class DetailActivity extends AppCompatActivity {
    private int num;
    private Handler han=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private Banner ban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        initData();
        jiexi();
    }

    private void jiexi() {
        CommonJieXi com=new CommonJieXi();
        String url="http://m.yunifang.com/yunifang/mobile/goods/detail?random=42187&encode=168d21c6d627072293fbbb0a44cc72e9&id="+num;
        com.getdata(url, new CommonJieXi.CallData() {
            @Override
            public void call(String str) {
                Message msg=new Message();
                msg.obj=str;
                han.sendMessage(msg);
            }
        });

    }

    private void initData() {
    }

    private void initView() {
        ban = (Banner) findViewById(R.id.ban);
    }
}
