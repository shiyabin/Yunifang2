package com.bwie.yunifang;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * Created by jinguo on 2017/3/16.
 */

public class CrashApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        ImageLoaderConfiguration aaa=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(aaa);
        //全局的异常捕获
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
    }
}
