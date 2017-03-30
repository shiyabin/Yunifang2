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


public class Duotuadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Bean> bean;

    public Duotuadapter(Context context, List<Bean> bean) {
        this.context=context;
        this.bean=bean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Myreadap(View.inflate(context,R.layout.recy_duotiao,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(bean.get(position).getData().getSubjects().get(position).getImage(),((Myreadap)holder).task_tp);
//        ((Myreadap)holder).taskTv_name.setText(goodsList.get(position).getGoods_name());
//        ((Myreadap)holder).taskTv_price.setText("￥"+goodsList.get(position).getShop_price());
        ((Myreadap)holder).recy_item.setAdapter(new RecyItem(context,bean));
    }

    @Override
    public int getItemCount() {
        return bean.size();
    }


    class Myreadap extends RecyclerView.ViewHolder{
        public ImageView task_tp;
        private final RecyclerView recy_item;

        public Myreadap(View itemView) {
            super(itemView);
            task_tp = (ImageView) itemView.findViewById(R.id.taskIv_tp);
            recy_item = (RecyclerView) itemView.findViewById(R.id.recy_item);
        }
    }
}
