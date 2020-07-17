package com.example.xingzhi.holographicteaching.net;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @explain
 * @author JC.
 * @creat time 2019/10/30 15:21.
 */

public abstract class RetrofitCallback<M> implements Callback<M> {

    public abstract void onSuccess(M model);

    public abstract void onFailure(int code, String msg);

    public abstract void onThrowable(Throwable t);

    public abstract void onFinish();

    @Override
    public void onResponse(Call<M> call, Response<M> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            onFailure(response.code(), response.errorBody().toString());
        }
        onFinish();
    }

    @Override
    public void onFailure(Call<M> call, Throwable t) {
        onThrowable(t);
        onFinish();
    }
}
