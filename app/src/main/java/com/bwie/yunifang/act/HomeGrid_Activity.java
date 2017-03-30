package com.bwie.yunifang.act;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.bwie.yunifang.R;

public class HomeGrid_Activity extends AppCompatActivity {

    private WebView gr_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_grid);
        gr_web = (WebView) findViewById(R.id.gr_web);
        Intent intent=getIntent();
        String htp = intent.getStringExtra("htp");
        gr_web.loadUrl(htp);
    }
}
