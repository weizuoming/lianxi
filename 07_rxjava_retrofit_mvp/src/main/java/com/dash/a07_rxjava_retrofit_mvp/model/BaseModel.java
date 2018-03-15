package com.dash.a07_rxjava_retrofit_mvp.model;

import com.dash.a07_rxjava_retrofit_mvp.presenter.IBaseRequestCallBack;

import java.util.Map;

/**
 * Created by Dash on 2018/3/14.
 */
public interface BaseModel<T> {

    void getDataFromNet(String url, Map<String,String> map, IBaseRequestCallBack<T> iBaseRequestCallBack);

    void onUnsubscribe();

}
