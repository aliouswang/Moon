package com.example.aliouswang.common.config;

import com.example.aliouswang.common.http.HopeHttp;

import java.io.File;
import java.net.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
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

    public HttpGlobalConfig connectTimeout(int timeout) {
        HopeHttp.getOkHttpBuilder().connectTimeout(timeout, TimeUnit.SECONDS);
        return this;
    }

    public HttpGlobalConfig readTimeout(int timeout) {
        HopeHttp.getOkHttpBuilder().readTimeout(HopeConfig.HTTP_READ_TIMEOUT, TimeUnit.SECONDS);
        return this;
    }

    public HttpGlobalConfig writeTimeout(int writeTimeout) {
        HopeHttp.getOkHttpBuilder().writeTimeout(HopeConfig.HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS);
        return this;
    }

    public HttpGlobalConfig addInterceptor(Interceptor interceptor) {
        HopeHttp.getOkHttpBuilder().addInterceptor(checkNotNull(interceptor, "interceptor == null"));
        return this;
    }

    public static <T> T checkNotNull(T t, String message) {
        if (t == null) {
            throw new NullPointerException(message);
        }
        return t;
    }

    public CallAdapter.Factory getCallAdapterFactory() {
        return callAdapterFactory;
    }

    public Converter.Factory getConverterFactory() {
        return converterFactory;
    }

    public Call.Factory getCallFactory() {
        return callFactory;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return sslSocketFactory;
    }

    public HostnameVerifier getHostnameVerifier() {
        return hostnameVerifier;
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    public Map<String, String> getGlobalParams() {
        return globalParams;
    }

    public Map<String, String> getGlobalHeaders() {
        return globalHeaders;
    }

    public boolean isNeedHttpCache() {
        return needHttpCache;
    }

    public File getHttpCacheDirectory() {
        return httpCacheDirectory;
    }

    public boolean isNeedCookie() {
        return needCookie;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public int getRetryDelayMillis() {
        return retryDelayMillis;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
