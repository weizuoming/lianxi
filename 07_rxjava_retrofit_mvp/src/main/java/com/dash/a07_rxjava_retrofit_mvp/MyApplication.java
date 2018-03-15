package com.dash.a07_rxjava_retrofit_mvp;

import android.app.Application;

import com.dash.a07_rxjava_retrofit_mvp.util.ApiService;
import com.dash.a07_rxjava_retrofit_mvp.util.Constant;
import com.dash.a07_rxjava_retrofit_mvp.util.RetrofitUtil;

/**
 * Created by Dash on 2018/3/14.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static ApiService getApiService() {
        return RetrofitUtil.getInstance(Constant.BASE_URL).createService(ApiService.class);
    }
}
