package com.example.xingzhi.holographicteaching.net;

import android.util.ArrayMap;
import android.util.Log;

import com.example.xingzhi.holographicteaching.core.AppControl;
import com.example.xingzhi.holographicteaching.utils.DeviceUtil;
import com.example.xingzhi.holographicteaching.utils.MD5;
import com.example.xingzhi.holographicteaching.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class BasicParamsInterceptor implements Interceptor {
    private Map<String, String> mHeaderParamsMap = new HashMap<>();
    public BasicParamsInterceptor() {
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
        HttpUrl oldHttpUrl = oldRequest.url(); //
        Request newRequest = null;

        int time = DeviceUtil.getSecondTimestamp(new Date());
        Utils.getMMKV().encode(Utils.time, time);
        //构建签名字段的值
        ArrayMap<String, String> signParams = new ArrayMap<>();
        if ("POST".equals(oldRequest.method())) {
            FormBody formBody = null;
            if (oldRequest.body() instanceof FormBody) {
                FormBody.Builder bodyBuilder = new FormBody.Builder();
                formBody = (FormBody) oldRequest.body();
                // 先复制原来的参数
                for (int i = 0; i < formBody.size(); i++) {
                    signParams.put(formBody.encodedName(i), formBody.encodedValue(i));
                    bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
                }

                HashMap<String, String> map = toMap(signParams);//
                String signature = MD5.getSignature(map, "android");//
                // 添加公共参数
                if (formBody.size() > 0){
                    formBody = bodyBuilder
                            .addEncoded("sign", signature)
                            .build();
                }
            }
            //添加请求头
            Log.d("ZDC","请求头 time = " + time);
            Request.Builder rb = oldRequest.newBuilder();
            rb.addHeader("device", "HONOR AUM-TL20|android|8.0.0")
                    .addHeader("imei", "359597413688244-4655b31a529e70e2")
                    .addHeader("version", "1.0.0")
                    .addHeader("time", String.valueOf(time))
                    .addHeader("system", "android")
                    .addHeader("token", AppControl.getUserToken());
            if (oldRequest.body() instanceof FormBody){
                newRequest = rb.post(formBody).build();
            }else {
                rb.method(oldRequest.method(),
                        oldRequest.body());
                newRequest = rb.build();
            }
            Log.d("ZDC","header = " + newRequest.headers().toString());
            return chain.proceed(newRequest);
        }
        //get请求
        else  {
            Set<String> nameList = oldHttpUrl.queryParameterNames();//获取所有的键
            for (String name : nameList) {
                List<String> valueList = oldHttpUrl.queryParameterValues(name);//获取指定键名的值
                if (null != valueList && valueList.size() > 0) {
                    signParams.put(name, valueList.get(0));
                } else {
                    signParams.put(name, null);
                }
            }//
            HashMap<String, String> map = toMap(signParams);//
            String signature = MD5.getSignature(map, "android");//
            //新增签名字段
            HttpUrl url = oldHttpUrl.newBuilder()
                    .addQueryParameter("sign", signature)
                    .build();
            // 新的请求
            Request.Builder requestBuilder = oldRequest.newBuilder().url(url);//
            requestBuilder.method(oldRequest.method(),
                    oldRequest.body());

            //添加公共参数,添加到header中
            if (mHeaderParamsMap.size() > 0) {
                for (Map.Entry<String, String> params : mHeaderParamsMap.entrySet()) {
                    requestBuilder.header(params.getKey(), params.getValue());
                }
            }
            newRequest = requestBuilder.build();

            return chain.proceed(newRequest);
        }
    }

    public static HashMap<String, String> toMap(Object object) {
        HashMap<String, String> data = new HashMap<String, String>();
        // 将json字符串转换成jsonObject
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(object.toString());

            Iterator ite = jsonObject.keys();
            // 遍历jsonObject数据,添加到Map对象
            while (ite.hasNext()) {
                String key = ite.next().toString();
                String value = jsonObject.getString(key);
                data.put(key, value);
            }
            // 或者直接将 jsonObject赋值给Map
            // data = jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static class Builder {
        BasicParamsInterceptor mHttpCommonInterceptor;

        public Builder() {
            mHttpCommonInterceptor = new BasicParamsInterceptor();
        }

        public Builder addHeaderParams(String key, String value) {
            mHttpCommonInterceptor.mHeaderParamsMap.put(key, value);
            return this;
        }

        public Builder addHeaderParams(String key, int value) {
            return addHeaderParams(key, String.valueOf(value));
        }

        public Builder addHeaderParams(String key, float value) {
            return addHeaderParams(key, String.valueOf(value));
        }

        public Builder addHeaderParams(String key, long value) {
            return addHeaderParams(key, String.valueOf(value));
        }

        public Builder addHeaderParams(String key, double value) {
            return addHeaderParams(key, String.valueOf(value));
        }

        public BasicParamsInterceptor build() {
            return mHttpCommonInterceptor;
        }
    }
}
