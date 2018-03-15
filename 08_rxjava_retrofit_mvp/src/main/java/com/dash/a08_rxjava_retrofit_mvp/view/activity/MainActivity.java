package com.dash.a08_rxjava_retrofit_mvp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.dash.a08_rxjava_retrofit_mvp.R;
import com.dash.a08_rxjava_retrofit_mvp.presenter.CategryPresenter;
import com.dash.a08_rxjava_retrofit_mvp.util.Constant;
import com.dash.a08_rxjava_retrofit_mvp.view.iview.Imain;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity implements Imain {

    private CategryPresenter categryPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categryPresenter = new CategryPresenter(this);
        //产生关联
        categryPresenter.attachView(this);

        getData();
    }

    private void getData() {

        Map<String,String> map = new HashMap<>();
        //获取数据
        categryPresenter.getDataFromNet(Constant.CATEGARY_URL,map);
    }

    @Override
    public void onSuccess(ResponseBody responseBody) {
        try {
            Log.e("----",responseBody.string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        Log.e("----",throwable.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        categryPresenter.unsubcribe();//解除订阅

        if (categryPresenter.isViewAttached()) {//如果产生关联
            //解除关联
            categryPresenter.detachView();
        }

    }
}
