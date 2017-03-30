package com.bwie.yunifang.act;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.yunifang.R;
import com.bwie.yunifang.adapter.Recycleradapter;
import com.bwie.yunifang.adapter.Xiangqinagdapter;
import com.bwie.yunifang.bean.XaingQingBean;
import com.bwie.yunifang.shujuku.ShangPing;
import com.bwie.yunifang.shujuku.SqLiteDao;
import com.bwie.yunifang.utils.CommonJieXi;
import com.bwie.yunifang.utils.GlideImageLoader;
import com.bwie.yunifang.utils.ImageLoaderUtils;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;


public class XiangqingActivity extends AppCompatActivity {
    private List<String> images=new ArrayList<>();
    private List<XaingQingBean.DataBean.ActivityBean> acti;
    private List<XaingQingBean.DataBean.GoodsBean.GalleryBean> galleryBeen = new ArrayList<>();
    private List<XaingQingBean.DataBean.GoodsRelDetailsBean> goodsRelDetails;
    private Handler han=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String obj = (String) msg.obj;
            Gson gson = new Gson();
            xaingQingBean = gson.fromJson(obj, XaingQingBean.class);
            List<XaingQingBean.DataBean.GoodsBean.GalleryBean> gallery = xaingQingBean.getData().getGoods().getGallery();
            for (int i = 0; i <gallery.size() ; i++) {
                images.add(gallery.get(i).getNormal_url());
            }
            xq_ban.setImages(images).setImageLoader(new GlideImageLoader()).start();
            xq_ban.isAutoPlay(false);

            XaingQingBean.DataBean.GoodsBean goods = xaingQingBean.getData().getGoods();
            String goods_name = goods.getGoods_name();
            double shop_price =  goods.getShop_price();
            xqTv_name.setText(goods_name);
            xqTv_price.setText("￥"+shop_price);

            acti = xaingQingBean.getData().getActivity();
            Myadapter myadapter=new Myadapter();
            xqLv.setAdapter(myadapter);
            xqLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String description = acti.get(position).getDescription();
                    Intent intent=new Intent(XiangqingActivity.this,BushuiActivity.class);
                    intent.putExtra("buS",description);
                    startActivity(intent);
                }
            });
            goodsRelDetails = xaingQingBean.getData().getGoodsRelDetails();
            GridLayoutManager managet=new GridLayoutManager(XiangqingActivity.this,3,GridLayoutManager.VERTICAL,false);
            xq_trcy.setLayoutManager(managet);
//            Recycleradapter recycleradapter=new Recycleradapter(XiangqingActivity.this,goodsRelDetails);
            Xiangqinagdapter xiangqinagdapter=new Xiangqinagdapter(XiangqingActivity.this,goodsRelDetails);
            xq_trcy.setAdapter(xiangqinagdapter);
            xiangqinagdapter.notifyDataSetChanged();

        }
    };
    private WindowManager.LayoutParams params;
    private Banner xq_ban;
    private String num;
    private TextView xqTv_name;
    private TextView xqTv_price;
    private ListView xqLv;
    private RecyclerView xq_trcy;
    private Button but_gwc;
    private PopupWindow popupWindow;
    private ImageView popupwindow_image,gwc_lv_img4,gwc_lv_img3;
    private TextView popupwindow_xian,popupwindow_num,popupwindow_price,popupwindow_buy_num;
    private Button popupwindow_OK;
    private int i=1;
    private XaingQingBean xaingQingBean;
    private SqLiteDao dao;
    public static String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
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
                msg.what=1;
                han.sendMessage(msg);
            }
        });
    }

    private void initData() {
        Intent intent=getIntent();
        num = intent.getStringExtra("rexiao");
        dao= new SqLiteDao(this);
        but_gwc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopFormBottom();
            }
        });

    }

    private void showPopFormBottom() {
        View popupWindowView = getLayoutInflater().inflate(R.layout.popupwindow_item, null);
        //内容，高度，宽度

        popupWindow = new PopupWindow(popupWindowView, LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);

        //popupWindow = new PopupWindow(popupWindowView, LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT, true);

        //动画效果

        popupWindow.setAnimationStyle(R.style.take_photo_anim);

        //菜单背景色
        ColorDrawable dw = new ColorDrawable(0xffffffff);
        popupWindow.setBackgroundDrawable(dw);
        //宽度
        //popupWindow.setWidth(LayoutParams.WRAP_CONTENT);
        //高度
        //popupWindow.setHeight(LayoutParams.FILL_PARENT);
        //显示位置

        popupWindow.showAtLocation(getLayoutInflater().inflate(R.layout.activity_main, null), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);

        //设置背景半透明
        backgroundAlpha(1f);
        //关闭事件
        popupWindow.setOnDismissListener(new popupDismissListener());

        popupWindowView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                /*if( popupWindow!=null && popupWindow.isShowing()){
                    popupWindow.dismiss();
                    popupWindow=null;
                }*/
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
                return false;
            }
        });

        //初始化控件
        popupwindow_image=(ImageView) popupWindowView.findViewById(R.id.popupwindow_image);
        popupwindow_price=(TextView) popupWindowView.findViewById(R.id.popupwindow_price);
        popupwindow_num=(TextView) popupWindowView.findViewById(R.id.popupwindow_num);
        popupwindow_xian=(TextView) popupWindowView.findViewById(R.id.popupwindow_xian);
        popupwindow_buy_num=(TextView) popupWindowView.findViewById(R.id.popupwindow_buy_num);
        popupwindow_OK=(Button) popupWindowView.findViewById(R.id.popupwindow_OK);
        gwc_lv_img4=(ImageView) popupWindowView.findViewById(R.id.gwc_lv_img4);
        gwc_lv_img3=(ImageView) popupWindowView.findViewById(R.id.gwc_lv_img3);
        //赋值
        popupwindow_price.setText("¥" + xaingQingBean.getData().getGoods().getShop_price());
        popupwindow_num.setText("库存"+xaingQingBean.getData().getGoods().getCollect_count()+"件");
        popupwindow_xian.setText("限购5件");
        ImageLoader.getInstance().displayImage(xaingQingBean.getData().getGoods().getGoods_img(),popupwindow_image, ImageLoaderUtils.initOptions());
        gwc_lv_img3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                i--;
                if (i <= 0) {
                    Toast.makeText(XiangqingActivity.this, "商品最少为1件", Toast.LENGTH_SHORT).show();
                    i = 0;
                } else {
                    popupwindow_buy_num.setText(i + "");
                }

            }
        });
        gwc_lv_img4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                i++;
                if (i >= 6) {
                    Toast.makeText(XiangqingActivity.this, "商品限购5件", Toast.LENGTH_SHORT).show();
                    i = 5;
                } else {
                    popupwindow_buy_num.setText(i + "");
                }
            }
        });
        popupwindow_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShangPing shangPing=new ShangPing(xaingQingBean.getData().getGoods().getGoods_name(),xaingQingBean.getData().getGoods().getGoods_img(),num,i,xaingQingBean.getData().getGoods().getShop_price());
                dao.insertSp(shangPing);
                Toast.makeText(XiangqingActivity.this,"已经加入购物车",Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });



    }
    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }
    class popupDismissListener implements PopupWindow.OnDismissListener{

        @Override
        public void onDismiss() {
            backgroundAlpha(1f);
        }

    }

    private void initView() {
        xq_ban = (Banner) findViewById(R.id.xq_ban);
        xqTv_name = (TextView) findViewById(R.id.xqTv_name);
        xqTv_price = (TextView) findViewById(R.id.xqTv_price);
        xqLv = (ListView) findViewById(R.id.xqLv);
        xq_trcy = (RecyclerView) findViewById(R.id.xq_trcy);
        but_gwc = (Button) findViewById(R.id.but_gwc);
    }
    class  Myadapter extends BaseAdapter{
        @Override
        public int getCount() {
            return acti.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=View.inflate(XiangqingActivity.this,R.layout.xq_item,null);
            TextView xqLv_item= (TextView) convertView.findViewById(R.id.xqLv_item);
            xqLv_item.setText(acti.get(position).getTitle());
            return convertView;
        }
    }

}
