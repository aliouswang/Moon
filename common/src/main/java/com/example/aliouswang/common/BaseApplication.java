package com.example.aliouswang.common;

import android.app.Application;

import com.example.aliouswang.common.http.HopeHttp;

/**
 * Created by aliouswang on 2017/9/27.
 */

public class BaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        HopeHttp.init(this);
    }
}
