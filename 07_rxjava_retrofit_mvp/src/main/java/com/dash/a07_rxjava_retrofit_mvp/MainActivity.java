package com.dash.a07_rxjava_retrofit_mvp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dash.a07_rxjava_retrofit_mvp.model.bean.CategaryBean;
import com.dash.a07_rxjava_retrofit_mvp.presenter.CategoryPresenter;
import com.dash.a07_rxjava_retrofit_mvp.util.Constant;
import com.dash.a07_rxjava_retrofit_mvp.view.CategaryView;

import java.util.HashMap;
import java.util.Map;


/**
 * https://www.jianshu.com/p/426864584518
 */
public class MainActivity extends AppCompatActivity implements CategaryView{

    private CategoryPresenter categoryPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        categoryPresenter = new CategoryPresenter(this);
        progressDialog = new ProgressDialog(MainActivity.this);
        //        progressDialog.setTitle();
        progressDialog.setMessage("正在请求获取数据,请稍等!!!");

    }

    public void request(View view) {


        Map<String, String> map = new HashMap<>();
        categoryPresenter.getDataFromNet(Constant.CATEGARY_URL,map);


        /*//https://www.zhaoapi.cn/product%2FgetProductCatagory字符被转义---->出错原因

        //被观察者 订阅 一个观察者-----

        Map<String, String> map = new HashMap<>();


        RetrofitUtil.getInstance(Constant.BASE_URL).createService(ApiService.class).doGet("product/getProductCatagory",map)
                .subscribeOn(Schedulers.io())//指定网络请求数据在io线程
                .observeOn(AndroidSchedulers.mainThread())//回调数据在主线程
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            Log.e("--11--",responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("--22--",e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("----","完成");
                    }
                });*/

    }

    @Override
    public void showProgress() {
        /*if(progressDialog != null && !progressDialog.isShowing()){
            progressDialog.show();
        }*/
    }

    @Override
    public void disimissProgress() {
        /*if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }*/
    }

    @Override
    public void loadDataSuccess(CategaryBean tData) {
        //拿到数据设置适配器
        Log.e("----",tData.getData().get(0).getName());
    }

    @Override
    public void loadDataError(Throwable throwable) {
        Log.e("----",throwable.getMessage());
    }

    @Override
    protected void onStop() {
        super.onStop();

        categoryPresenter.onUnsubscribe();
    }
}
