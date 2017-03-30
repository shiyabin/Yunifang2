package com.bwie.yunifang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.yunifang.R;
import com.bwie.yunifang.bean.Bean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/3/19 16:36
 */


public class RecyItem extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Bean> beanlist;

    public RecyItem(Context context, List<Bean> beanlist) {
        this.context=context;
        this.beanlist=beanlist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Myreadap(View.inflate(context,R.layout.task_grid,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(beanlist.get(position).getData().getSubjects().get(position).getGoodsList().get(position).getGoods_img(),((Myreadap)holder).task_tp);
        ((Myreadap)holder).taskTv_name.setText(beanlist.get(position).getData().getSubjects().get(position).getGoodsList().get(position).getGoods_name());
        ((Myreadap)holder).taskTv_price.setText("￥"+beanlist.get(position).getData().getSubjects().get(position).getGoodsList().get(position).getShop_price());

    }

    @Override
    public int getItemCount() {
        return beanlist.size();
    }


    class Myreadap extends RecyclerView.ViewHolder{
        public ImageView task_tp;
        public TextView taskTv_name;
        public TextView taskTv_price;
        public Myreadap(View itemView) {
            super(itemView);
            task_tp = (ImageView) itemView.findViewById(R.id.taskIv_tp);
            taskTv_name = (TextView) itemView.findViewById(R.id.taskTv_name);
            taskTv_price = (TextView) itemView.findViewById(R.id.taskTv_price);
        }
    }
}
