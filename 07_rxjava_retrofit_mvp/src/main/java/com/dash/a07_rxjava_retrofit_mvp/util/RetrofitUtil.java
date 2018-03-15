package com.dash.a07_rxjava_retrofit_mvp.util;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dash on 2018/3/13.
 */
public class RetrofitUtil {

    private static RetrofitUtil retrofitUtil = null;
    private Retrofit retrofit;

    private RetrofitUtil() {
    }

    private RetrofitUtil(String baseUrl) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //.addNetworkInterceptor()//网络拦截器
                //.addInterceptor()//拦截器
                //.connectTimeout()//连接超时
                .build();


        //创建retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())//添加转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//设置支持rxjava 注意是2
                .build();
    }

    /**
     * 单例模式
     * @return
     */
    public static RetrofitUtil getInstance(String baseUrl) {
        if (retrofitUtil == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofitUtil == null) {
                    retrofitUtil = new RetrofitUtil(baseUrl);
                }
            }
        }

        return retrofitUtil;
    }

    public <T> T createService(Class<T> service) {
        return retrofit.create(service);
    }


}
