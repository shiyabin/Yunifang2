package com.bwie.yunifang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.yunifang.R;
import com.bwie.yunifang.act.DengLuActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/3/16 10:01
 */


public class MineFragment extends Fragment {

    private View view;
    private ListView mine_lv;
    private String[] str={"我的订单","邀请有礼","刷脸量尺寸","兑换专区","我的现金券","我的抽奖单","我收藏的商品","联系客服"};
    private int[] imsge={R.mipmap.t1,R.mipmap.t2,R.mipmap.t3,R.mipmap.t4,R.mipmap.t5,R.mipmap.t6,R.mipmap.t7,R.mipmap.t8};
    private ImageView mine_tx;
    private static String gAppid = "1105692541";
    private Tencent tencent;
    private UserInfo mInfo;
    private BaseUiListener listener;
    private TextView mineTv_dl;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mine_fragment,null);
        initView();
        initData();
        listener = new BaseUiListener();

        return view;
    }

    private void initData() {
        Myadapter adapter=new Myadapter();
        mine_lv.setAdapter(adapter);
        mine_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), DengLuActivity.class);
                startActivity(intent);
            }
        });
        mine_tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tencent.login(MineFragment.this, "all", new BaseUiListener());
            }
        });
        mineTv_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte=new Intent(getActivity(), DengLuActivity.class);
                startActivity(inte);
            }
        });


    }

    private void initView() {
        LinearLayout mine_dFuK= (LinearLayout) view.findViewById(R.id.mine_dFuk);
        LinearLayout mine_dFaH= (LinearLayout) view.findViewById(R.id.mine_dFaH);
        LinearLayout mine_dShouH= (LinearLayout) view.findViewById(R.id.mine_dShouH);
        LinearLayout mine_dPingJ= (LinearLayout) view.findViewById(R.id.mine_dPingJ);
        LinearLayout mine_TuiK= (LinearLayout) view.findViewById(R.id.mine_TuiK);
        mine_lv = (ListView) view.findViewById(R.id.mine_lv);
        mine_tx = (ImageView) view.findViewById(R.id.mine_tx);
        mineTv_dl = (TextView) view.findViewById(R.id.mineTv_dl);
        tencent = Tencent.createInstance(gAppid,getActivity().getApplication());
    }

    //QQ第三方登录
    private class BaseUiListener implements IUiListener {
        @Override
        public void onComplete(Object response) {
            Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
            Log.e("tag", "response:" + response);
            JSONObject jo = (JSONObject) response;

            try {
                String openID = jo.getString("openid");
                String accessToken = jo.getString("access_token");
                String expires = jo.getString("expires_in");
                tencent.setOpenId(openID);
                tencent.setAccessToken(accessToken, expires);
                QQToken qqToken = tencent.getQQToken();
                mInfo = new UserInfo(getActivity(), qqToken);
                mInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e("BaseUiListener", "成功"+response.toString());
                        JSONObject object= (JSONObject) response;
                        String figureurl_qq_2 = object.optString("figureurl_qq_2");
                        ImageLoader.getInstance().displayImage(figureurl_qq_2,mine_tx);
                        String nickname = object.optString("nickname");
                        mineTv_dl.setText(nickname);
                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e("BaseUiListener", "失败"+uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e("BaseUiListener", "取消");
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(getActivity(), "登录失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel() {
            Toast.makeText(getActivity(), "登录取消", Toast.LENGTH_SHORT).show();

        }

    }


    class  Myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return str.length;
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
                convertView=View.inflate(getActivity(),R.layout.mine_lv,null);
            ImageView lv_iv= (ImageView) convertView.findViewById(R.id.lv_iv);
            lv_iv.setImageResource(imsge[position]);
            TextView lv_tv= (TextView) convertView.findViewById(R.id.lv_tv);
            lv_tv.setText(str[position]);

            return convertView;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("TAG", "-->onActivityResult " + requestCode  + " resultCode=" + resultCode);
        if (requestCode == Constants.REQUEST_LOGIN ||
                requestCode == Constants.REQUEST_APPBAR) {
            Tencent.onActivityResultData(requestCode,resultCode,data,listener);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
