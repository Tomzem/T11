package com.tomze.tiu.net;

import com.tomze.tiu.app.T11Application;
import com.tomze.tiu.app.URLs;
import com.tomze.tiu.util.T11Utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Tomze
 * @time 2019年04月06日 12:34
 * @desc 网络请求RM
 */
public class RM {
    private static volatile RM mInstance;
    private final Retrofit mRetrofit;

    private RM() {
        String baseURL = URLs.RELEASE_BASE_URL;
        if (T11Utils.isDebug(T11Application.getContext())) {
            baseURL = URLs.DEBUG_BASE_URL;
        }

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new TokenInterceptor())
                .writeTimeout(10000, TimeUnit.MILLISECONDS)
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 获取RM的实例
     */
    public static RM getInstance() {
        if (mInstance == null) {
            synchronized (RM.class) {
                if (mInstance == null) {
                    mInstance = new RM();
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取Service接口实例
     */
    public <T> T create(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }
}
