package com.bwie.yunifang.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.yunifang.R;
import com.bwie.yunifang.act.HomeGrid_Activity;
import com.bwie.yunifang.act.XiangqingActivity;
import com.bwie.yunifang.bean.Bean;
import com.bwie.yunifang.fragment.HomeFragment;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/3/19 16:36
 */


public class Myrecy extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Bean.DataBean.BestSellersBean.GoodsListBean> goodsList;

    public Myrecy(Context context, List<Bean.DataBean.BestSellersBean.GoodsListBean> goodsList) {
        this.context=context;
        this.goodsList=goodsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Myreadap(View.inflate(context,R.layout.task_grid,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ImageLoader.getInstance().displayImage(goodsList.get(position).getGoods_img(),((Myreadap)holder).task_tp);
        ((Myreadap)holder).taskTv_name.setText(goodsList.get(position).getGoods_name());
        ((Myreadap)holder).taskTv_price.setText("￥"+goodsList.get(position).getShop_price());
        ((Myreadap)holder).linl_rexiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = goodsList.get(position).getId();
                Intent intent=new Intent(context, XiangqingActivity.class);
                intent.putExtra("rexiao",id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }


    class Myreadap extends RecyclerView.ViewHolder{
        public ImageView task_tp;
        public TextView taskTv_name;
        public TextView taskTv_price;
        private final LinearLayout linl_rexiao;

        public Myreadap(View itemView) {
            super(itemView);
            task_tp = (ImageView) itemView.findViewById(R.id.taskIv_tp);
            taskTv_name = (TextView) itemView.findViewById(R.id.taskTv_name);
            taskTv_price = (TextView) itemView.findViewById(R.id.taskTv_price);
            linl_rexiao = (LinearLayout) itemView.findViewById(R.id.linl_rexiao);
        }
    }
}
