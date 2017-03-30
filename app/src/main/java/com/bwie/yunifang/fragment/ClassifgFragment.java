package com.bwie.yunifang.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SearchViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bwie.yunifang.R;
import com.bwie.yunifang.act.BushuiActivity;
import com.bwie.yunifang.adapter.Mygridrecy;
import com.bwie.yunifang.adapter.Myrecy;
import com.bwie.yunifang.adapter.StarRecy;
import com.bwie.yunifang.bean.ClassifgBean;
import com.bwie.yunifang.utils.CommonJieXi;
import com.google.gson.Gson;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/3/16 10:01
 */


public class ClassifgFragment extends Fragment implements View.OnClickListener {

    private View view;
    private List<ClassifgBean.DataBean.CategoryBean.ChildrenBean> children;
    private List<ClassifgBean.DataBean.CategoryBean.ChildrenBean> children2;
    private List<ClassifgBean.DataBean.GoodsBriefBean> goodsBrief;
    private ClassifgBean classifgBean;
    private Handler han=new Handler(){




        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String obj = (String) msg.obj;
            Gson gson = new Gson();
            //功效
            ClassifgBean classifgBean =  gson.fromJson(obj, ClassifgBean.class);
            children = classifgBean.getData().getCategory().get(0).getChildren();
            MyGridadapter myGridadapter=new MyGridadapter();
            classifg_grid.setAdapter(myGridadapter);
            //肤质
            children2 = classifgBean.getData().getCategory().get(2).getChildren();
            GridLayoutManager managet=new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
            recy.setLayoutManager(managet);
            Mygridrecy mygrid=new Mygridrecy(getActivity(),children2);
            recy.setAdapter(mygrid);
            mygrid.notifyDataSetChanged();

            goodsBrief = classifgBean.getData().getGoodsBrief();
            GridLayoutManager managet2=new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
            trcycler.setLayoutManager(managet2);
            StarRecy starRecy=new StarRecy(getActivity(),goodsBrief);
            trcycler.setAdapter(starRecy);
            starRecy.notifyDataSetChanged();



        }
};
    private GridView classifg_grid;
    private RecyclerView recy;
    private RecyclerView trcycler;
    private ImageView classifg_mianmo;
    private ImageView classifg_rfs;
    private ImageView classifg_rfr;
    private ImageView classifg_jmr;
    private ImageView classifg_qt;
    private ImageView classifg_tz;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.classifg_fragment,null);
        //网络判断
        if(isNetworkAvailable(getActivity())) {
            initView();
            initData();
            jieshuju();
        } else {
            Toast.makeText(getActivity(), "没有可用的网络",Toast.LENGTH_SHORT).show();
        }
        return view;
    }

    private void jieshuju() {
        CommonJieXi com=new CommonJieXi();
        String url="http://m.yunifang.com/yunifang/mobile/category/list?random=96333&encode=bf3386e14fe5bb0bcef234baebca2414";
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
        classifg_mianmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                classifgBean.getData().getCategory().get(1).getChildren().get()
            }
        });
        classifg_rfs.setOnClickListener(this);
        classifg_rfr.setOnClickListener(this);
        classifg_jmr.setOnClickListener(this);
        classifg_qt.setOnClickListener(this);
        classifg_tz.setOnClickListener(this);

    }

    private void initView() {
        classifg_grid = (GridView) view.findViewById(R.id.classifg_grid);
        recy = (RecyclerView) view.findViewById(R.id.recy);
        trcycler = (RecyclerView) view.findViewById(R.id.trcycler);
        classifg_mianmo = (ImageView) view.findViewById(R.id.classifg_mianmo);
        classifg_rfs = (ImageView) view.findViewById(R.id.classifg_rfs);
        classifg_rfr = (ImageView) view.findViewById(R.id.classifg_rfr);
        classifg_jmr = (ImageView) view.findViewById(R.id.classifg_jmr);
        classifg_qt = (ImageView) view.findViewById(R.id.classifg_qt);
        classifg_tz = (ImageView) view.findViewById(R.id.classifg_tz);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.classifg_mianmo:

                break;
            case R.id.classifg_rfs:
                break;
            case R.id.classifg_rfr:
                break;
            case R.id.classifg_jmr:
                break;
            case R.id.classifg_qt:
                break;
            case R.id.classifg_tz:
                break;
        }

    }

    class  MyGridadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return children.size();
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
            convertView=View.inflate(getActivity(),R.layout.classifg_grid,null);
            Button classifg_GrBut= (Button) convertView.findViewById(R.id.classifg_GrBut);
            classifg_GrBut.setText(children.get(position).getCat_name());
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
