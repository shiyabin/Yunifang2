package com.bwie.yunifang.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.yunifang.R;
import com.bwie.yunifang.act.DingDanActivity;
import com.bwie.yunifang.shujuku.ShangPing;
import com.bwie.yunifang.shujuku.SqLiteDao;
import com.bwie.yunifang.utils.ImageLoaderUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/3/16 10:01
 */


public class TradeFragment extends Fragment {


    private TextView gwc_tv1;
    private TextView gwc_tv2;
    private TextView gwc_tv3;
    private TextView gwc_tv4;
    private ListView gwc_lv;
    private CheckBox img_nox;
    private Button gwc_but_jisuan;
    private SqLiteDao dao;
    private List<ShangPing> list = new ArrayList<ShangPing>();
    private Adapter_gwc_lv adapter_gwc_lv;
    private double zongmoney = 0;
    private boolean flag;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.trade_fragment,null);
        //初始化控件
        initView();
        initData();
        dao = new SqLiteDao(getActivity());
        return view;
    }

    private void initView() {
        gwc_tv1 = (TextView) view.findViewById(R.id.gwc_tv1);
        gwc_tv2 = (TextView) view.findViewById(R.id.gwc_tv2);
        gwc_tv3 = (TextView) view.findViewById(R.id.gwc_tv3);
        gwc_tv4 = (TextView) view.findViewById(R.id.gwc_tv4);
        gwc_lv = (ListView) view.findViewById(R.id.gwc_lv);
        img_nox = (CheckBox) view.findViewById(R.id.img_nox);
        gwc_but_jisuan = (Button) view.findViewById(R.id.gwc_but_jisuan);
    }
    private void initData(){
        gwc_lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ShangPing shang = (ShangPing) adapter_gwc_lv.getItem(position);
                gwc_lv.removeView(view);
                adapter_gwc_lv.notifyDataSetChanged();
                return false;

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences spf = getActivity().getSharedPreferences("denglu", getActivity().MODE_PRIVATE);
        /*int zhuangtai = spf.getInt("zhuangtai", 0);
        if (zhuangtai == 0) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }*/
        list = dao.querySp();
        if (list.size() != 0) {
            gwc_tv1.setText("购物车(" + list.size() + ")");
        } else {
            gwc_tv1.setText("购物车(0)");
        }
        adapter_gwc_lv = new Adapter_gwc_lv(list,getActivity());
        gwc_lv.setAdapter(adapter_gwc_lv);
        img_nox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                flag = img_nox.isChecked();
                if (flag == true) {
                    double zj = 0.0f;
                    for (int i = 0; i < adapter_gwc_lv.getSelect().size(); i++) {
                        adapter_gwc_lv.getSelect().set(i, flag);
                    }
                    for (int i = 0; i < adapter_gwc_lv.getSelect().size(); i++) {
                        if (adapter_gwc_lv.getSelect().get(i) == true) {
                            zj = (adapter_gwc_lv.linkp.get(i)) * (adapter_gwc_lv.link.get(i));
                            zongmoney = zongmoney + zj;
                        } else {
                            zj = (adapter_gwc_lv.linkp.get(i)) * (adapter_gwc_lv.link.get(i));
                            zongmoney = zongmoney - zj;
                        }
                    }
                    // 点击全选之后把总价赋值给适配器
                    adapter_gwc_lv.mm = zongmoney;
                    if (zongmoney > 0) {
                        gwc_tv4.setText("总计：¥" + new DecimalFormat("#0.00").format(zongmoney));
                    } else {
                        gwc_tv4.setText("总计：¥" + new DecimalFormat("#0.00").format(0));
                    }

                } else {
                    boolean selects = img_nox.isChecked();
                    for (int i = 0; i < adapter_gwc_lv.getSelect().size(); i++) {
                        adapter_gwc_lv.getSelect().set(i, selects);
                    }
                    zongmoney = 0;
                    adapter_gwc_lv.mm = zongmoney;
                    gwc_tv4.setText("总计：¥" + new DecimalFormat("#0.00").format(zongmoney));
                }

                adapter_gwc_lv.notifyDataSetChanged();
            }
        });
        adapter_gwc_lv.notifyDataSetChanged();
        //点击编辑
        gwc_tv2.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                i++;
                adapter_gwc_lv.ChuanZhi(i);
                if (i % 2 != 0) {
                    gwc_tv2.setText("完成");
                    //gwc_but_jisuan.setText("删除");
                    //删除
//                    gwc_but_jisuan.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            //dao.deleteSp();
//                        }
//                    });
                } else {
                    gwc_tv2.setText("编辑");
                    gwc_but_jisuan.setText("结算");
                    for (int i = 0; i < adapter_gwc_lv.getLink().size(); i++) {
                        dao.Update(list.get(i).getName(), adapter_gwc_lv.getLink().get(i));
                    }
                    // 查询数据库拿到最新数据，设置到adapter
                    List<ShangPing> data = dao.querySp();
                    list.clear();
                    list.addAll(data);
                    adapter_gwc_lv = new Adapter_gwc_lv(list, getActivity());
                    gwc_lv.setAdapter(adapter_gwc_lv);
                }
                adapter_gwc_lv.notifyDataSetChanged();
            }
        });
        if (!adapter_gwc_lv.getSelect().contains(true)) {
            // check_all.setChecked(false);
        } else {
            for (int i = 0; i < adapter_gwc_lv.getSelect().size(); i++) {
                if (adapter_gwc_lv.getSelect().get(i)) {
                    adapter_gwc_lv.getSelect().set(i, false);
                } else {
                    adapter_gwc_lv.getSelect().set(i, true);
                }
            }
            if (!adapter_gwc_lv.getSelect().contains(true)) {
                img_nox.setChecked(false);
            }
        }
        adapter_gwc_lv.notifyDataSetChanged();
        gwc_but_jisuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), DingDanActivity.class);
                intent.putExtra("name", list.get(0).getName());
                intent.putExtra("count", list.get(0).getCount());
                intent.putExtra("price", list.get(0).getPrice());
                intent.putExtra("img", list.get(0).getImgurl());
                startActivity(intent);
            }
        });
    }
    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        list = dao.querySp();
        if (list.size() != 0) {
            gwc_tv1.setText("购物车(" + list.size() + ")");
        } else {
            gwc_tv1.setText("购物车(0)");
        }
        adapter_gwc_lv = new Adapter_gwc_lv(list, getActivity());
        gwc_lv.setAdapter(adapter_gwc_lv);
    }

    private class Adapter_gwc_lv extends BaseAdapter {

        List<ShangPing> list;
        Context context;
        private CheckBox gwc_lv_img1;
        private ImageView gwc_lv_img2;
        private TextView gwc_lv_tv1;
        private TextView gwc_lv_tv2;
        private TextView gwc_lv_tv3;
        private LinearLayout gwc_lv_zi;
        private LinkedList<Boolean> linkedList = new LinkedList<Boolean>();
        private LinkedList<Integer> link = new LinkedList<Integer>();
        private LinkedList<Double> linkp = new LinkedList<Double>();
        private int n;
        public double mm = 0.0f;
        private ImageView gwc_lv_img3;
        private TextView gwc_lv_tv5;
        private ImageView gwc_lv_img4;

        public Adapter_gwc_lv(List<ShangPing> list, Context context) {
            super();
            this.list = list;
            this.context = context;

            // 初始化
            for (int i = 0; i < list.size(); i++) {
                getSelect().add(false);
            }
            // 初始化
            for (int i = 0; i < list.size(); i++) {
                link.add(list.get(i).getCount());
            }

            for (int i = 0; i < list.size(); i++) {
                linkp.add(list.get(i).getPrice());
            }
        }

        public LinkedList<Integer> getLink() {
            return link;
        }

        private List<Boolean> getSelect() {
            return linkedList;
        }

        public void ChuanZhi(int i) {
            this.n = i;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return list.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            if (convertView == null) {
                convertView = View.inflate(context, R.layout.gwc_lv_zibuju, null);
            }
            gwc_lv_img1 = (CheckBox) convertView.findViewById(R.id.gwc_lv_img1);
            gwc_lv_img2 = (ImageView) convertView.findViewById(R.id.gwc_lv_img2);
            gwc_lv_tv1 = (TextView) convertView.findViewById(R.id.gwc_lv_tv1);
            gwc_lv_tv2 = (TextView) convertView.findViewById(R.id.gwc_lv_tv2);
            gwc_lv_tv3 = (TextView) convertView.findViewById(R.id.gwc_lv_tv3);
            gwc_lv_zi = (LinearLayout) convertView.findViewById(R.id.gwc_lv_zi);
            gwc_lv_img3 = (ImageView) convertView.findViewById(R.id.gwc_lv_img3);
            gwc_lv_tv5 = (TextView) convertView.findViewById(R.id.gwc_lv_tv5);
            gwc_lv_img4 = (ImageView) convertView.findViewById(R.id.gwc_lv_img4);
            ImageLoader.getInstance().displayImage(list.get(position).getImgurl(), gwc_lv_img2, ImageLoaderUtils.initOptions());
            gwc_lv_tv1.setText(list.get(position).getName());
            gwc_lv_tv2.setText("￥" + list.get(position).getPrice());
            gwc_lv_tv3.setText("数量：" + list.get(position).getCount());
            if (n % 2 != 0) {
                gwc_lv_zi.setVisibility(View.VISIBLE);
                gwc_lv_tv3.setVisibility(View.INVISIBLE);
            } else {
                gwc_lv_zi.setVisibility(View.GONE);
                gwc_lv_tv3.setVisibility(View.VISIBLE);
            }
            gwc_lv_img1.setChecked(linkedList.get(position));
            gwc_lv_img1.setOnClickListener(new View.OnClickListener() {
                private double zj = 0.0f;

                @Override
                public void onClick(View v) {
                    linkedList.set(position, !linkedList.get(position));
                    // linkedList集合中当前角标的状态
                    if (linkedList.get(position) == true) {
                        // 状态为true，link所存的商品数量*传入集合中的商品价格（角标相同，所以一一对应）
                        zj = (linkp.get(position)) * (adapter_gwc_lv.link.get(position));
                        // 赋值给定义的全局变量（也就是总价）
                        mm = mm + zj;
                    } else {
                        zj = (linkp.get(position)) * (adapter_gwc_lv.link.get(position));
                        mm = mm - zj;
                    }
                    // 把经过计算的总价set到控件
                    if (mm > 0) {
                        gwc_tv4.setText("总计：¥" + new DecimalFormat("#0.00").format(mm));
                    } else {
                        gwc_tv4.setText("总计：¥" + new DecimalFormat("#0.00").format(0));
                    }
                    // 判断：如果linklist里包含false，全选不选中，否则（都是true的情况下）选中全选。
                    if (linkedList.contains(false)) {
                        img_nox.setChecked(false);
                        zongmoney = 0;
                    } else {
                        img_nox.setChecked(true);
                        zongmoney = mm;
                    }
                    notifyDataSetChanged();
                }
            });
            gwc_lv_tv5.setText(link.get(position) + "");
            gwc_lv_img3.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (link.get(position) <= 1) {
                        Toast.makeText(getActivity(), "商品不能少于1件哟!", Toast.LENGTH_SHORT).show();
                    } else {
                        link.set(position, (link.get(position) - 1));
                        gwc_lv_tv5.setText(link.get(position) + "");
                    }
                    notifyDataSetChanged();
                }
            });
            gwc_lv_img4.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (link.get(position) >= 5) {
                        Toast.makeText(getActivity(), "本商品限购5件哟!", Toast.LENGTH_SHORT).show();
                    } else {
                        link.set(position, (link.get(position) + 1));
                        gwc_lv_tv5.setText(link.get(position) + "");
                    }
                    notifyDataSetChanged();
                }
            });

            return convertView;
        }

    }
}
