package com.example.aliouswang.common.http.request;

import com.example.aliouswang.common.config.HttpGlobalConfig;
import com.example.aliouswang.common.http.mode.HttpHeader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Interceptor;
import retrofit2.Retrofit;

/**
 * Created by aliouswang on 2017/10/4.
 */

public abstract class BaseRequest <R extends BaseRequest>{

    protected HttpGlobalConfig httpGlobalConfig;
    protected List<Interceptor> interceptors = new ArrayList<>();
    protected List<Interceptor> networkInterceptors = new ArrayList<>();
    protected Retrofit retrofit;
    protected HttpHeader httpHeader = new HttpHeader();
    protected String baseUrl;
    protected int readTimeout;
    protected int writeTimeout;
    protected int connectTimeout;
    protected Object tag;
    protected boolean isHttpCache;

    public R baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return (R) this;
    }

    public R addHeader(String key, String value) {
        this.httpHeader.put(key, value);
        return (R) this;
    }

    public R addHeaders(Map<String, String> headers) {
        this.httpHeader.put(headers);
        return (R) this;
    }

    public R removeHeader(String key) {
        this.httpHeader.remove(key);
        return (R) this;
    }

    public R tag(Object tag) {
        this.tag = tag;
        return (R) this;
    }

    public R readTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return (R) this;
    }

    public R writeTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
        return (R) this;
    }

    public R connectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return (R) this;
    }


}
