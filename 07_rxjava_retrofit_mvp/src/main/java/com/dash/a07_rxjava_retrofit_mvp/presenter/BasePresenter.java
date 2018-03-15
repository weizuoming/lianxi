package com.dash.a07_rxjava_retrofit_mvp.presenter;

import com.dash.a07_rxjava_retrofit_mvp.view.IBaseView;

/**
 * Created by Dash on 2018/3/14.
 */
public class BasePresenter<V extends IBaseView, T> implements IBaseRequestCallBack<T> {

    private IBaseView iBaseView;

    public BasePresenter(V view) {
        this.iBaseView = view;
    }

    @Override
    public void beforeRequest() {
        iBaseView.showProgress();
    }

    @Override
    public void requestError(Throwable throwable) {
        iBaseView.loadDataError(throwable);
        iBaseView.disimissProgress();
    }

    @Override
    public void requestComplete() {
        iBaseView.disimissProgress();
    }

    @Override
    public void requestSuccess(T callBack) {
        iBaseView.loadDataSuccess(callBack);
    }
}
