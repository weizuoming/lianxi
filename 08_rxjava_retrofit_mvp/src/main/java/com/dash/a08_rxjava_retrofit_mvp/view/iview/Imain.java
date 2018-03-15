package com.dash.a08_rxjava_retrofit_mvp.view.iview;

import okhttp3.ResponseBody;

/**
 * Created by Dash on 2018/3/14.
 */
public interface Imain {

    void onSuccess(ResponseBody responseBody);
    void onError(Throwable throwable);

}
