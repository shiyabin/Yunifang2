package com.bwie.yunifang.act;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.bwie.yunifang.R;

public class LunBoActivity extends AppCompatActivity {

    private WebView web_lunbo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lun_bo);
        web_lunbo = (WebView) findViewById(R.id.web_lunbo);
        Intent intent=getIntent();
        String lunbo = intent.getStringExtra("lunbo");
        web_lunbo.loadUrl(lunbo);
    }
}
