package com.example.aliouswang.common.http;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by aliouswang on 2017/9/29.
 */

public class HopeHttp {

    private static Context context;
    private static OkHttpClient.Builder okHttpBuilder;
    private static Retrofit.Builder retrofitBuilder;

    private static final String NOT_INIT_ERROR = "Make sure call HopeHttp.init(this) in your application onCreate method!";

    public static void init(Context appContext) {
        context = appContext.getApplicationContext();
        okHttpBuilder = new OkHttpClient.Builder();
        retrofitBuilder = new Retrofit.Builder();
    }

    public static Context getContext() {
        if (context == null) {
            throw new IllegalStateException(NOT_INIT_ERROR);
        }
        return context;
    }

    public static OkHttpClient.Builder getOkHttpBuilder() {
        if (okHttpBuilder == null) {
            throw new IllegalStateException(NOT_INIT_ERROR);
        }
        return okHttpBuilder;
    }

    public static Retrofit.Builder getRetrofitBuilder() {
        if (retrofitBuilder == null) {
            throw new IllegalStateException(NOT_INIT_ERROR);
        }
        return retrofitBuilder;
    }

}
