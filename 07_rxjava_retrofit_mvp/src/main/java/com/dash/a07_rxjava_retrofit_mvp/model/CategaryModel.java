package com.dash.a07_rxjava_retrofit_mvp.model;

import com.dash.a07_rxjava_retrofit_mvp.MyApplication;
import com.dash.a07_rxjava_retrofit_mvp.model.bean.CategaryBean;
import com.dash.a07_rxjava_retrofit_mvp.presenter.IBaseRequestCallBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by Dash on 2018/3/14.
 */
public class CategaryModel implements BaseModel<CategaryBean> {

    private CompositeDisposable compositeDisposable;

    public CategaryModel() {
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getDataFromNet(String url, Map<String,String> map, final IBaseRequestCallBack<CategaryBean> iBaseRequestCallBack) {

        MyApplication.getApiService().doPost(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //Disposable是1.x的Subscription改名的，因为Reactive-Streams规范用这个名称，为了避免重复
                        //这个回调方法是在2.0之后新添加的
                        //可以使用d.dispose()方法来取消订阅
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();

                            CategaryBean categaryBean = new Gson().fromJson(json,CategaryBean.class);
                            //回调接口：请求成功，获取实体类对象
                            iBaseRequestCallBack.requestSuccess(categaryBean);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        //回调接口：请求异常
                        iBaseRequestCallBack.requestError(e);
                    }

                    @Override
                    public void onComplete() {
                        //回调接口：请求已完成，可以隐藏progress
                        iBaseRequestCallBack.requestComplete();
                    }
                });

    }

    @Override
    public void onUnsubscribe() {
       compositeDisposable.clear();
    }
}
