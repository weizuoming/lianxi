package com.dash.a05_retrofit;


import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by Dash on 2018/3/12.
 *
 * 可以把这个接口当做我们之前写的ApiUtil类
 *
 */
public interface ApiService {

    //注解后面是路径,,,但是这个路径比较特殊
    //https://www.zhaoapi.cn/----baseUrl ----http://163.16.11.22:8080/
    // product/getProductCatagory----相对路径----linzhiling/lingzhiling.jpg

    @GET("product/getProductCatagory")
    Call<CategaryBean> getCategary();

    //https://www.zhaoapi.cn/product/searchProducts?keywords=笔记本&page=1&source=android

    @GET("product/searchProducts")
    Call<SearchBean> getSearch(@QueryMap Map<String,String> map);

    //post传递的是表单数据
    @FormUrlEncoded
    @POST("product/searchProducts")
    Call<SearchBean> postSearch(@FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST("product/searchProducts")
    Call<SearchBean> postSearch_02(@Field("keywords") String keywords,@Field("page") String page,@Field("source") String source);

    @GET("users/{user}/repos") //{user}请求路径上的占位符
    Call<ResponseBody>  getBlog(@Path("user") String user);
    // 访问的API是：https://api.github.com/users/{user}/repos
    // 在发起请求时， {user} 会被替换为方法的第一个参数 user（被@Path注解作用）

}
