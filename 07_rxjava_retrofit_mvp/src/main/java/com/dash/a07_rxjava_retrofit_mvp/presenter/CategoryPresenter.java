package com.dash.a07_rxjava_retrofit_mvp.presenter;

import com.dash.a07_rxjava_retrofit_mvp.model.bean.CategaryBean;
import com.dash.a07_rxjava_retrofit_mvp.model.CategaryModel;
import com.dash.a07_rxjava_retrofit_mvp.view.CategaryView;

import java.util.Map;

/**
 * Created by Dash on 2018/3/14.
 */
public class CategoryPresenter extends BasePresenter<CategaryView,CategaryBean> implements Ipresenter {

    private CategaryModel categaryModel;

    public CategoryPresenter(CategaryView view) {
        super(view);
        categaryModel = new CategaryModel();
    }

    @Override
    public void getDataFromNet(String url, Map<String, String> map) {
        categaryModel.getDataFromNet(url,map,this);
    }

    @Override
    public void onUnsubscribe() {
        categaryModel.onUnsubscribe();
    }
}
