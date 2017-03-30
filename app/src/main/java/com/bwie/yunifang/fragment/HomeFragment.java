package com.bwie.yunifang.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.yunifang.R;
import com.bwie.yunifang.act.ErweimaActivity;
import com.bwie.yunifang.act.HomeGrid_Activity;
import com.bwie.yunifang.act.LunBoActivity;
import com.bwie.yunifang.adapter.Myrecy;
import com.bwie.yunifang.adapter.Recycleradapter;
import com.bwie.yunifang.adapter.StarRecy;
import com.bwie.yunifang.bean.Bean;
import com.bwie.yunifang.utils.CommonJieXi;
import com.bwie.yunifang.utils.GlideImageLoader;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途 首页
 * 2. @author Administrator
 * 3. @date 2017/3/16 10:01
 */


public class HomeFragment extends Fragment {
    private View view;
    private PullToRefreshScrollView ptrl;
    private List<String> images=new ArrayList<>();
    private List<Bean.DataBean.Ad5Bean> ad5;
    private List<Bean.DataBean.BestSellersBean> bestSellers;
    private Banner banner;
    private GridView home_gv;
    private TextView task_tv;
    private RecyclerView recy;
    private Myrecy myrecy;
    private List<String> list_image=new ArrayList<>();
    private Handler han=new Handler(){
        private List<Bean.DataBean.Ad1Bean> ad1;
        private Bean bean;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1) {
                String obj = (String) msg.obj;
                Gson gson = new Gson();
                bean = gson.fromJson(obj, Bean.class);
                ad1 = bean.getData().getAd1();
                for (int i = 0; i < ad1.size(); i++) {
                    images.add(ad1.get(i).getImage());
                }
                banner.setIndicatorGravity(BannerConfig.RIGHT);
                banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
                //轮播
                banner.setImages(images).setImageLoader(new GlideImageLoader()).start();
                ;
                banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        String adTypeDynamicData = ad1.get(position).getAd_type_dynamic_data();
                        Intent intent=new Intent(getActivity(), LunBoActivity.class);
                        intent.putExtra("lunbo",adTypeDynamicData);
                        startActivity(intent);
                    }
                });
                //任务栏
                ad5 = bean.getData().getAd5();
                MyGvadapter mygvadapter=new MyGvadapter();
                home_gv.setAdapter(mygvadapter);
                //本周热销
                bestSellers = bean.getData().getBestSellers();
                task_tv.setText(bestSellers.get(0).getName());

                List<Bean.DataBean.BestSellersBean.GoodsListBean> goodsList = bean.
                        getData().getBestSellers().get(0).getGoodsList();
                recy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
                myrecy = new Myrecy(getActivity(),goodsList);
                recy.setAdapter(myrecy);
                myrecy.notifyDataSetChanged();


                //优惠活动
                activityInfoList = bean.getData().getActivityInfo().getActivityInfoList();
                for (int i = 0; i < activityInfoList.size(); i++) {
                    list_image.add(activityInfoList.get(i).getActivityImg());
                }
                //轮播
                ban.setBannerStyle(BannerConfig.NOT_INDICATOR);
                ban.setImages(list_image).setImageLoader(new GlideImageLoader()).start();
                ban.isAutoPlay(false);


                defaultGoodsList = bean.getData().getDefaultGoodsList();
                GridLayoutManager managet=new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(managet);
                Recycleradapter recycleradapter=new Recycleradapter(getActivity(),defaultGoodsList);
                recyclerView.setAdapter(recycleradapter);
                recycleradapter.notifyDataSetChanged();

            }
        }
    };
    private List<Bean.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfoList;
    private RecyclerView recycl;
    private RecyclerView recyclerView;
    private RecyclerView recy_dt;
    private Banner ban;
    private GridView home_grid;
    private List<Bean.DataBean.DefaultGoodsListBean> defaultGoodsList;
    private ImageView home_xx;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)  {
        view = inflater.inflate(R.layout.home_fragment,null);
        //网络判断
        if(isNetworkAvailable(getActivity())) {
            initView();
            jiexi();
            task();
        } else {
            Toast.makeText(getActivity(), "没有可用的网络",Toast.LENGTH_SHORT).show();
        }
        return view;
    }

    private void task(){
        home_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ad_type_dynamic_data = ad5.get(position).getAd_type_dynamic_data();
                Intent intent=new Intent(getActivity(), HomeGrid_Activity.class);
                intent.putExtra("htp",ad_type_dynamic_data);
                startActivity(intent);
            }
        });
    }
    private void jiexi() {
        CommonJieXi com=new CommonJieXi();
        String url="http://m.yunifang.com/yunifang/mobile/home?random=84831&encode=9dd34239798e8cb22bf99a75d1882447";
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
    private void initView() {
        ptrl = (PullToRefreshScrollView) view.findViewById(R.id.ptrl);
        banner = (Banner) view.findViewById(R.id.ban);
        home_gv = (GridView) view.findViewById(R.id.home_gv);
        task_tv = (TextView) view.findViewById(R.id.task_tv);

        recy = (RecyclerView) view.findViewById(R.id.recy);
        ban = (Banner) view.findViewById(R.id.banner);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recy_dt = (RecyclerView) view.findViewById(R.id.recy_dt);

        home_xx = (ImageView) view.findViewById(R.id.home_xx);

        home_xx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ErweimaActivity.class);
                startActivity(intent);
            }
        });

    }
    class  MyGvadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return ad5.size();
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
            convertView=View.inflate(getActivity(),R.layout.home_grid,null);
            ImageView grid_iv= (ImageView) convertView.findViewById(R.id.grid_iv);
            ImageLoader.getInstance().displayImage(ad5.get(position).getImage(),grid_iv);
            TextView grid_tv= (TextView) convertView.findViewById(R.id.grid_tv);
            grid_tv.setText(ad5.get(position).getTitle());
            return convertView;
        }

    }
    // 判断当前是否有可用的网络
    public boolean isNetworkAvailable(Activity activity) {
        Context context = activity.getApplicationContext();
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        } else {
            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    System.out.println(i + "===状态==="
                            + networkInfo[i].getState());
                    System.out.println(i + "===类型==="
                            + networkInfo[i].getTypeName());
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
