package com.example.xingzhi.holographicteaching.net;

import com.example.xingzhi.holographicteaching.modle.MainModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
/**
 * @explain
 * @author JC.
 * @creat time 2019/10/30 15:11.
 */
public interface ApiStores {

    //baseUrl
    String API_SERVER_URL = "https://www.weather.com.cn/";

    //加载天气
    @GET("adat/sk/{cityId}.html")
    Call<MainModel> loadDataByRetrofit(@Path("cityId") String cityId);

    //加载天气
    @GET("adat/sk/{cityId}.html")
    Observable<MainModel> LoginRequest(@Path("cityId") String cityId);

    @POST("sdk.user.login")
    Observable<MainModel> loginRetrofitRxJava(@Path("cityId") String cityId);



}
