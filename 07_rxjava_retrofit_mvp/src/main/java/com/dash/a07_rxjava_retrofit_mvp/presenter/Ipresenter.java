package com.dash.a07_rxjava_retrofit_mvp.presenter;

import java.util.Map;

/**
 * Created by Dash on 2018/3/14.
 */
public interface Ipresenter {
    void getDataFromNet(String url, Map<String,String> map);

    void onUnsubscribe();
}
