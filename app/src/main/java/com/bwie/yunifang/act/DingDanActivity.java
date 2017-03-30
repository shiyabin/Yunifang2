package com.bwie.yunifang.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.yunifang.R;
import com.bwie.yunifang.pay.PayDemoActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

public class DingDanActivity extends AppCompatActivity {

    private ImageView imga_dd_fanhui;
    private TextView tv_shdz;
    private ImageView dd_img;
    private TextView dd_name;
    private TextView dd_shul;
    private TextView dd_price;
    private Button dd_but;
    private TextView dd_zj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding_dan);
        //初始化控件
        initView();
    }
    /**
     * 初始化
     */
    private void initView() {
        Intent intent = getIntent();
        String img = intent.getStringExtra("img");
        String name = intent.getStringExtra("name");
        double price = intent.getDoubleExtra("price", 0.00);
        int count = intent.getIntExtra("count", 0);
        imga_dd_fanhui = (ImageView) findViewById(R.id.imga_dd_fanhui);
        imga_dd_fanhui.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        tv_shdz = (TextView) findViewById(R.id.tv_shdz);
        dd_img = (ImageView) findViewById(R.id.dd_img);
        ImageLoader.getInstance().displayImage(img, dd_img);
        dd_name = (TextView) findViewById(R.id.dd_name);
        dd_name.setText(name);
        dd_shul = (TextView) findViewById(R.id.dd_shul);
        dd_shul.setText("商品数量:" + count);
        dd_price = (TextView) findViewById(R.id.dd_price);
        dd_price.setText("商品价格:" + price);
        dd_zj = (TextView) findViewById(R.id.dd_zj);
        dd_but = (Button) findViewById(R.id.dd_but);
        dd_zj.setText("总价：￥" + price * count);

        dd_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(DingDanActivity.this, PayDemoActivity.class);
                startActivity(intent1);
            }
        });
        tv_shdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(DingDanActivity.this,DiTuActivity.class);
                startActivityForResult(intent1,1);

    }
});
        if(intent.hasExtra("地址")){
            Bundle bundle = intent.getExtras();

            String data = bundle.getString("地址");

            tv_shdz.setText(data);
        }else{
            tv_shdz.setText("请填写收货地址");
        }
    }
}
