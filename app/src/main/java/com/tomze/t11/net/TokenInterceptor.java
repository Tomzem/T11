package com.tomze.t11.net;

import android.text.TextUtils;

import com.tomze.t11.util.T11SharePre;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Tomze
 * @time 2019年04月06日 12:39
 * @desc Token 拦截器
 */
public class TokenInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        String token = T11SharePre.getData("userToken", "");
        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .method(original.method(), original.body());
        if (TextUtils.isEmpty(token)) {
            requestBuilder.addHeader("token", token);
        }
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
