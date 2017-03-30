package com.bwie.yunifang.act;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.bwie.yunifang.R;

public class BushuiActivity extends AppCompatActivity {

    private WebView bushuiWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bushui);
        bushuiWeb = (WebView) findViewById(R.id.bushuiWeb);
        Intent intent=getIntent();
        String buS = intent.getStringExtra("buS");
        bushuiWeb.loadUrl(buS);

    }
}
