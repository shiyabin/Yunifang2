package com.bwie.yunifang.act;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bwie.yunifang.R;
import com.bwie.yunifang.adapter.Myadapter;
import com.bwie.yunifang.ui.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private SharedPreferences sha;
    private ImageView hy4_iv;
    private List<View> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.vp);
        sha = getSharedPreferences("user", MODE_PRIVATE);

        boolean f = sha.getBoolean("flag", false);
        if (f) {
            Intent intent = new Intent(MainActivity.this,GreetActivity.class);
            startActivity(intent);
        }
        View hy1 = View.inflate(this, R.layout.ht1, null);
        View hy2 = View.inflate(this, R.layout.ht2, null);
        View hy3 = View.inflate(this, R.layout.ht3, null);
        View hy4 = View.inflate(this, R.layout.ht4, null);

        hy4_iv = (ImageView) hy4.findViewById(R.id.hy4_iv);
        list = new ArrayList<>();
        list.add(hy1);
        list.add(hy2);
        list.add(hy3);
        list.add(hy4);
        vp.setAdapter(new Myadapter(this,list));
        hy4_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sha=getSharedPreferences("user", MODE_PRIVATE);
                SharedPreferences.Editor ed=sha.edit();
                ed.putBoolean("flag", true);
                ed.commit();

                Intent it=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(it);


            }
        });
//                finish();

    }
}
