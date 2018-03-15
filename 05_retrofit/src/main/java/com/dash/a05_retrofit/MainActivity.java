package com.dash.a05_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 1.添加依赖
 * 2.生成处理数据的javaBean类
 * 3.创建一个网络请求的接口,,,里面使用注解进行get/post请求的方法
 * 4.创建retrofit实例,并且指定baseUrl
 * 5.创建 网络请求接口实例
 * 6.执行异步或者同步请求
 */
public class MainActivity extends AppCompatActivity {

    private TextView text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_view = findViewById(R.id.text_view);

    }


    // Unable to create converter转换器 for class com.dash.a05_retrofit.CategaryBean
    //不能够为CategaryBean创建一个转换器---response.body().string()---json字符串--Gson->CategaryBean
    //json xml jackSon --->对应着不同的转换器
    public void getCategory(View view) {

        Retrofit retrofit = new Retrofit.Builder()//构建者模式
                .baseUrl(Constant.BASE_URL)//设置baseUrl
                .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                .build();

        //需要使用retrofit创建一个网络请求的接口
        ApiService apiService = retrofit.create(ApiService.class);

        Call<CategaryBean> call = apiService.getCategary();

        call.enqueue(new Callback<CategaryBean>() {
            @Override
            public void onResponse(Call<CategaryBean> call, Response<CategaryBean> response) {
                if (response.isSuccessful()) {
                    CategaryBean categaryBean = response.body();

                    //主线程还是子线程????---主线程,,retrofit自动完成了线程的切换
                    text_view.setText(categaryBean.getMsg());
                }
            }

            @Override
            public void onFailure(Call<CategaryBean> call, Throwable t) {

            }
        });

    }

    public void getCategory_02(View view) {

        //这部分代码其实是写在model里面的

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Map<String, String> params = new HashMap<>();
        params.put("keywords","笔记本");
        params.put("page","1");
        params.put("source","android");

        //Call<SearchBean> call = apiService.getSearch(params);

        //Call<SearchBean> call = apiService.postSearch(params);

        Call<SearchBean> call = apiService.postSearch_02("笔记本", "1", "android");

        call.enqueue(new Callback<SearchBean>() {
            @Override
            public void onResponse(Call<SearchBean> call, Response<SearchBean> response) {
                text_view.setText(response.body().getData().get(0).getTitle());
            }

            @Override
            public void onFailure(Call<SearchBean> call, Throwable t) {

            }
        });

    }
}
