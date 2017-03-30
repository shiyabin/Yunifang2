package com.bwie.yunifang.act;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.bwie.yunifang.R;
import com.bwie.yunifang.ui.home.HomeActivity;

public class GreetActivity extends AppCompatActivity {
    private Handler han =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Intent i = new Intent(GreetActivity.this, HomeActivity.class);
            startActivity(i);
//            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet);
        han.sendEmptyMessageDelayed(0,2000);

    }
}
