package com.dash.a08_rxjava_retrofit_mvp.model;

import java.util.Map;

/**
 * Created by Dash on 2018/3/14.
 */
public interface BaseModel {
    void getDataFromNet(String url, Map<String, String> map);
    void unsubcribe();
}
