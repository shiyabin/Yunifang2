package com.bwie.yunifang.utils;

import com.bwie.yunifang.bean.Bean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/3/17 20:04
 */


public class CommonJieXi {
    public Bean.DataBean getdata(String url,final CallData calldata){
        OkHttpClient mOkHttpClient=new OkHttpClient();
        final Request request=new Request.Builder()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String htmlString = response.body().string();
                calldata.call(htmlString);

            }
        });
        return null;
    }
    public interface  CallData{
        void  call(String st);
    }
}
