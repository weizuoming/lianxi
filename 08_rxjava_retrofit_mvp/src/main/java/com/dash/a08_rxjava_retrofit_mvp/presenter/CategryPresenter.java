package com.dash.a08_rxjava_retrofit_mvp.presenter;

import com.dash.a08_rxjava_retrofit_mvp.view.iview.Imain;
import com.dash.a08_rxjava_retrofit_mvp.model.CategaryModel;

import java.util.Map;

import okhttp3.ResponseBody;

/**
 * Created by Dash on 2018/3/14.
 */
public class CategryPresenter extends BasePresenter implements Ipresenter {

    private Imain imain;
    private CategaryModel categaryModel;

    public CategryPresenter(Imain imain) {
        this.imain = imain;
        categaryModel = new CategaryModel(this);

    }


    @Override
    public void getDataFromNet(String url, Map<String, String> map) {

        categaryModel.getDataFromNet(url,map);

    }

    @Override
    public void onSuccess(ResponseBody responseBody) {
        imain.onSuccess(responseBody);
    }

    @Override
    public void onError(Throwable throwable) {
        imain.onError(throwable);
    }

    @Override
    public void unsubcribe() {
        //接触订阅
        categaryModel.unsubcribe();
    }
}
