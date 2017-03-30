package com.bwie.yunifang.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.yunifang.R;
import com.bwie.yunifang.fragment.ClassifgFragment;
import com.bwie.yunifang.fragment.HomeFragment;
import com.bwie.yunifang.fragment.MineFragment;
import com.bwie.yunifang.fragment.TradeFragment;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_xw;
    private ImageView iv_sp;
    private ImageView iv_fx;
    private ImageView iv_wd;
    private TextView tv_xw;
    private TextView tv_sp;
    private TextView tv_fx;
    private TextView tv_wd;
    private LinearLayout btn_sy;
    private LinearLayout btn_fl;
    private LinearLayout btn_gwc;
    private LinearLayout btn_wd;
    private HomeFragment homeFrag;
    private ClassifgFragment classifgFrag;
    private TradeFragment tradeFrag;
    private MineFragment mineFrag;
    private long mkeyTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
       initData();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if((System.currentTimeMillis() - mkeyTime) > 2000){

                mkeyTime = System.currentTimeMillis();
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_LONG).show();
            }else{
                finish();
            }

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
    public void initData(){
        //点击监听
        btn_sy.setOnClickListener(this);
        btn_fl.setOnClickListener(this);
        btn_gwc.setOnClickListener(this);
        btn_wd.setOnClickListener(this);
        homeFrag = new HomeFragment();
        classifgFrag = new ClassifgFragment();
        tradeFrag = new TradeFragment();
        mineFrag = new MineFragment();
        //默认选择HomeFragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fl,homeFrag).commit();
    }
    public void initView(){
        btn_sy = (LinearLayout) findViewById(R.id.btn_sy);
        btn_fl = (LinearLayout) findViewById(R.id.btn_fl);
        btn_gwc = (LinearLayout) findViewById(R.id.btn_gwc);
        btn_wd = (LinearLayout) findViewById(R.id.btn_wd);
        iv_xw = (ImageView) findViewById(R.id.iv_xw);
        iv_sp = (ImageView) findViewById(R.id.iv_sp);
        iv_fx = (ImageView) findViewById(R.id.iv_fx);
        iv_wd = (ImageView) findViewById(R.id.iv_wd);
        tv_xw = (TextView) findViewById(R.id.tv_xw);
        tv_sp = (TextView) findViewById(R.id.tv_sp);
        tv_fx = (TextView) findViewById(R.id.tv_fx);
        tv_wd = (TextView) findViewById(R.id.tv_wd);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sy:
                FragmentManager manager1 = getSupportFragmentManager();

                FragmentTransaction transaction1 = manager1.beginTransaction();

                transaction1.replace(R.id.fl,homeFrag);

                transaction1.commit();

                iv_xw.setBackgroundResource(R.mipmap.sy2);
                tv_xw.setTextColor(Color.RED);

                iv_sp.setBackgroundResource(R.mipmap.fl);
                tv_sp.setTextColor(Color.BLACK);

                iv_fx.setBackgroundResource(R.mipmap.gwc);
                tv_fx.setTextColor(Color.BLACK);

                iv_wd.setBackgroundResource(R.mipmap.gr2);
                tv_wd.setTextColor(Color.BLACK);
                break;
            case R.id.btn_fl:
                FragmentManager manager2 = getSupportFragmentManager();

                FragmentTransaction transaction2 = manager2.beginTransaction();

                transaction2.replace(R.id.fl,classifgFrag);

                transaction2.commit();

                iv_xw.setBackgroundResource(R.mipmap.sy);
                tv_xw.setTextColor(Color.BLACK);

                iv_sp.setBackgroundResource(R.mipmap.fl2);
                tv_sp.setTextColor(Color.RED);

                iv_fx.setBackgroundResource(R.mipmap.gwc);
                tv_fx.setTextColor(Color.BLACK);

                iv_wd.setBackgroundResource(R.mipmap.gr2);
                tv_wd.setTextColor(Color.BLACK);
                break;
            case R.id.btn_gwc:
                FragmentManager manager3 = getSupportFragmentManager();

                FragmentTransaction transaction3 = manager3.beginTransaction();

                transaction3.replace(R.id.fl,tradeFrag);

                transaction3.commit();

                iv_xw.setBackgroundResource(R.mipmap.sy);
                tv_xw.setTextColor(Color.BLACK);

                iv_sp.setBackgroundResource(R.mipmap.fl);
                tv_sp.setTextColor(Color.BLACK);

                iv_fx.setBackgroundResource(R.mipmap.gwc2);
                tv_fx.setTextColor(Color.RED);

                iv_wd.setBackgroundResource(R.mipmap.gr2);
                tv_wd.setTextColor(Color.BLACK);
                break;
            case R.id.btn_wd:
                FragmentManager manager4 = getSupportFragmentManager();

                FragmentTransaction transaction4 = manager4.beginTransaction();

                transaction4.replace(R.id.fl,mineFrag);

                transaction4.commit();

                iv_xw.setBackgroundResource(R.mipmap.sy);
                tv_xw.setTextColor(Color.BLACK);

                iv_sp.setBackgroundResource(R.mipmap.fl);
                tv_sp.setTextColor(Color.BLACK);

                iv_fx.setBackgroundResource(R.mipmap.gwc);
                tv_fx.setTextColor(Color.BLACK);

                iv_wd.setBackgroundResource(R.mipmap.gr);
                tv_wd.setTextColor(Color.RED);
                break;

        }

    }

}
