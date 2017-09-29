package com.example.aliouswang.common.config;

import com.example.aliouswang.common.http.HopeHttp;

import java.io.File;
import java.net.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

import okhttp3.Call;
import okhttp3.ConnectionPool;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/**
 * Created by aliouswang on 2017/9/29.
 */

public class HttpGlobalConfig {
    private CallAdapter.Factory callAdapterFactory;
    private Converter.Factory converterFactory;
    private Call.Factory callFactory;
    private SSLSocketFactory sslSocketFactory;
    private HostnameVerifier hostnameVerifier;
    private ConnectionPool connectionPool;
    private Map<String, String> globalParams = new LinkedHashMap<>();
    private Map<String, String> globalHeaders = new LinkedHashMap<>();
    private boolean needHttpCache;
    private File httpCacheDirectory;
    private boolean needCookie;

    private String baseUrl;
    private int retryDelayMillis;
    private int retryCount;

    private static volatile HttpGlobalConfig instance;
    private HttpGlobalConfig() {}

    public static HttpGlobalConfig getInstance() {
        if (instance == null) {
            synchronized (HttpGlobalConfig.class) {
                if (instance == null) {
                    instance = new HttpGlobalConfig();
                }
            }
        }
        return instance;
    }

    public HttpGlobalConfig callAdapterFactory(CallAdapter.Factory factory) {
        this.callAdapterFactory = factory;
        return this;
    }

    public HttpGlobalConfig converterFactory(Converter.Factory factory) {
        this.converterFactory = factory;
        return this;
    }

    public HttpGlobalConfig callFactory(Call.Factory factory) {
        this.callFactory = factory;
        return this;
    }

    public HttpGlobalConfig sslSocketFactory(SSLSocketFactory sslSocketFactory) {
        this.sslSocketFactory = sslSocketFactory;
        return this;
    }

    public HttpGlobalConfig hostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
        return this;
    }

    public HttpGlobalConfig connectionPool(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        return this;
    }

    public HttpGlobalConfig globalConfig(Map<String, String> globalHeaders) {
        this.globalHeaders = globalHeaders;
        return this;
    }

    public HttpGlobalConfig globalParams(Map<String, String> globalParams) {
        this.globalParams = globalParams;
        return this;
    }

    public HttpGlobalConfig setHttpCache(boolean needHttpCache) {
        this.needHttpCache = needHttpCache;
        return this;
    }

    public HttpGlobalConfig setHttpCacheDirectory(File httpCacheDirectory) {
        this.httpCacheDirectory = httpCacheDirectory;
        return this;
    }

    public HttpGlobalConfig setCookie(boolean needCookie) {
        this.needCookie = needCookie;
        return this;
    }

    public HttpGlobalConfig baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public HttpGlobalConfig retryDelayMills(int retryDelayMillis) {
        this.retryDelayMillis = retryDelayMillis;
        return this;
    }

    public HttpGlobalConfig retryCount(int retryCount) {
        this.retryCount = retryCount;
        return this;
    }

    public HttpGlobalConfig proxy(Proxy proxy) {
        HopeHttp.getOkHttpBuilder().proxy(checkNotNull(proxy, "proxy == null"));
        return this;
    }

    public static <T> T checkNotNull(T t, String message) {
        if (t == null) {
            throw new NullPointerException(message);
        }
        return t;
    }

}
