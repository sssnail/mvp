package com.example.xingzhi.holographicteaching.net;


import android.util.Log;

import com.example.xingzhi.holographicteaching.BuildConfig;
import com.example.xingzhi.holographicteaching.utils.DeviceUtil;
import com.example.xingzhi.holographicteaching.utils.Utils;

import java.io.IOException;
import java.util.Date;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit mRetrofit;

    public static Retrofit retrofit() {
        if (mRetrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            //添加公共参数拦截器

//            builder.addInterceptor(HeaderInterceptor);
            BasicParamsInterceptor basicParamsInterceptor = new BasicParamsInterceptor
                    .Builder()
//                    .addHeaderParams("device", "HONOR AUM-TL20|android|8.0.0")
//                    .addHeaderParams("imei", "359597413688244-4655b31a529e70e2")
//                    .addHeaderParams("version", "1.0.0")
//                    .addHeaderParams("time", time)
//                    .addHeaderParams("system", "android")
//                    .addHeaderParams("token", "")
//                    .addHeaderParams("sign", "F0DA2CE79DAA657D1DC5C8FFE4DB74DDANDROID")
                    .build();
            builder.addInterceptor(basicParamsInterceptor);

            if (BuildConfig.DEBUG) {
                // Log信息拦截器
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                //设置 Debug Log 模式
                builder.addInterceptor(loggingInterceptor);
            }
            OkHttpClient okHttpClient = builder.build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(ApiStores.API_SERVER)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return mRetrofit;
    }

    static Interceptor HeaderInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request build = chain.request().newBuilder()
                    .addHeader("session", String.valueOf(3))
                    .build();
            return chain.proceed(build);
        }
    };

}
