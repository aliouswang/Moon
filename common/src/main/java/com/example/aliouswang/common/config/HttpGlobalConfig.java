package com.example.aliouswang.common.config;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

import okhttp3.ConnectionPool;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/**
 * Created by aliouswang on 2017/9/29.
 */

public class HttpGlobalConfig {
    private CallAdapter.Factory callAdapterFactory;
    private Converter.Factory coverterFactory;
    private CallAdapter.Factory callFactory;
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


}
