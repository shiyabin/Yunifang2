package com.bwie.yunifang.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.yunifang.R;
import com.bwie.yunifang.act.XiangqingActivity;
import com.bwie.yunifang.bean.Bean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/3/19 16:36
 */


public class Recycleradapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
     List<Bean.DataBean.DefaultGoodsListBean> defaultGoodsList;

    public Recycleradapter(Context context, List<Bean.DataBean.DefaultGoodsListBean> defaultGoodsList) {
        this.context=context;
        this.defaultGoodsList=defaultGoodsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Myreadap(View.inflate(context,R.layout.home_item,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ImageLoader.getInstance().displayImage(defaultGoodsList.get(position).getGoods_img(),((Myreadap)holder).task_tp);
        ((Myreadap)holder).taskTv_name.setText(defaultGoodsList.get(position).getGoods_name());
        ((Myreadap)holder).taskTv_price.setText("￥"+defaultGoodsList.get(position).getShop_price());
        ((Myreadap)holder).lin_gr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = defaultGoodsList.get(position).getId();
                Intent intent=new Intent(context, XiangqingActivity.class);
                intent.putExtra("rexiao",id);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return defaultGoodsList.size();
    }


    class Myreadap extends RecyclerView.ViewHolder{
        public ImageView task_tp;
        public TextView taskTv_name;
        public TextView taskTv_price;
        private final LinearLayout lin_gr;

        public Myreadap(View itemView) {
            super(itemView);
            task_tp = (ImageView) itemView.findViewById(R.id.taskIv_tp);
            taskTv_name = (TextView) itemView.findViewById(R.id.taskTv_name);
            taskTv_price = (TextView) itemView.findViewById(R.id.taskTv_price);
            lin_gr = (LinearLayout) itemView.findViewById(R.id.lin_gr);
        }
    }
}
