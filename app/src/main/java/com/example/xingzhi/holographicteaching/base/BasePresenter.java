package com.example.xingzhi.holographicteaching.base;

import com.example.xingzhi.holographicteaching.net.ApiClient;
import com.example.xingzhi.holographicteaching.net.ApiStores;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


/**
 * @explain 业务逻辑基类
 */
public class BasePresenter<V> {
    public V mvpView;
    protected ApiStores apiStores;
    private CompositeDisposable mCompositeDisposable;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
        apiStores = ApiClient.retrofit().create(ApiStores.class);
    }


    public void detachView() {
        this.mvpView = null;
        onUnSubscribe();
    }


    //RxJava取消注册，以避免内存泄露
    public void onUnSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }


    public void addSubscription(Observable observable, DisposableObserver observer) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }

        mCompositeDisposable.add(observer);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer);
    }
    /**
     * 参数集合 便于加公共参数
     */
    public Map<String, String> getHashMap(){
        return new HashMap<String, String>();
    }

}
