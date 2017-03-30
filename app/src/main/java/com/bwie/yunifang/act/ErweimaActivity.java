package com.bwie.yunifang.act;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bwie.yunifang.R;
import com.uuzuche.lib_zxing.activity.CodeUtils;

public class ErweimaActivity extends AppCompatActivity {

    private ImageView er_iv;
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erweima);
        er_iv = (ImageView) findViewById(R.id.er_iv);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.biao);
        //生成二维码
        mBitmap = CodeUtils.createImage("御泥坊APP", 400, 400, bitmap);
        er_iv.setImageBitmap(mBitmap);
    }
}
