package com.example.aliouswang.common.http;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by aliouswang on 2017/9/29.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST()
    Observable<ResponseBody> post(@Url() String url, @FieldMap Map<String, String> maps);

}
