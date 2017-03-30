package com.bwie.yunifang.act;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.yunifang.R;
import com.bwie.yunifang.adapter.Recycleradapter;
import com.bwie.yunifang.adapter.Shuxingrecy;
import com.bwie.yunifang.bean.Bean;
import com.bwie.yunifang.bean.ShuXingBean;
import com.bwie.yunifang.utils.CommonJieXi;
import com.google.gson.Gson;

import java.util.List;

public class ShuxingActivity extends AppCompatActivity {

    private RecyclerView shuxing_recy;
    private String num;
    private List<ShuXingBean.DataBean> data;
    private ShuXingBean shuXingBean;
    private Handler han=new Handler(){



        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String obj = (String) msg.obj;
            Gson gson = new Gson();
//            bean = gson.fromJson(obj, Bean.class);
            shuXingBean = gson.fromJson(obj, ShuXingBean.class);
            data = shuXingBean.getData();

            GridLayoutManager managet=new GridLayoutManager(ShuxingActivity.this,2,GridLayoutManager.VERTICAL,false);
            shuxing_recy.setLayoutManager(managet);
//            Shuxingrecy recycleradapter=new Recycleradapter(ShuxingActivity.this,data);
            Shuxingrecy shuxingrecy=new Shuxingrecy(ShuxingActivity.this,data);
            shuxing_recy.setAdapter(shuxingrecy);
            shuxingrecy.notifyDataSetChanged();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuxing);
        shuxing_recy = (RecyclerView) findViewById(R.id.shuxing_recy);
        jiexi();
        initData();
    }

    private void initData() {

    }

    private void jiexi() {
        CommonJieXi com=new CommonJieXi();
        String url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id="+num;
        com.getdata(url, new CommonJieXi.CallData() {
            @Override
            public void call(String str) {
                Message msg=new Message();
                msg.obj=str;
                msg.what=1;
                han.sendMessage(msg);
            }
        });
    }
}
