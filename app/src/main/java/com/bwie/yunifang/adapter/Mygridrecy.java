package com.bwie.yunifang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.yunifang.R;
import com.bwie.yunifang.bean.Bean;
import com.bwie.yunifang.bean.ClassifgBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/3/19 16:36
 */


public class Mygridrecy extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<ClassifgBean.DataBean.CategoryBean.ChildrenBean> children2;

    public Mygridrecy(Context context, List<ClassifgBean.DataBean.CategoryBean.ChildrenBean> children2) {
        this.context=context;
        this.children2=children2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Myreadap(View.inflate(context,R.layout.classifg_grid2,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Myreadap)holder).gridBut.setText(children2.get(position).getCat_name());

    }

    @Override
    public int getItemCount() {
        return children2.size();
    }


    class Myreadap extends RecyclerView.ViewHolder{

        private final Button gridBut;

        public Myreadap(View itemView) {
            super(itemView);
            gridBut = (Button) itemView.findViewById(R.id.gridBut);

        }
    }
}
