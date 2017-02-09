package com.apptest.main;

import android.content.Context;

import com.apptest.R;
import com.apptest.retrofit.dependencies.ApiModule;
import com.apptest.retrofit.dependencies.DaggerApiComponent;
import com.apptest.retrofit.interfaces.RetrofitResponse;

import java.util.HashMap;

import dagger.Module;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by davidpayel on 08/02/2017.
 */

@Module
public class BaseModelModule {

    protected Context context;
    protected Observable observable;
    protected Retrofit retrofit;
    protected RetrofitResponse retrofitResponse;
    protected int service;
    protected int USERID = R.string.userId;
    protected HashMap maps;
    protected int userId = 0;

    protected void retrofit(){
        retrofit = DaggerApiComponent.builder()
                .apiModule(new ApiModule())
                .build()
                .retrofit();
    }

    protected void maps(){
        maps = retrofitResponse.onBody(service);
        if(maps.get(USERID) != null){
            userId = Integer.parseInt(maps.get(USERID).toString());
            maps.remove(USERID);
        }
    }

    protected void observable(){
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Object>>() {
                    @Override
                    public void onNext(Response response) {
                        retrofitResponse.onStatusResponse(response);
                    }

                    @Override
                    public void onCompleted() {
                        retrofitResponse.onComplete(context.getString(R.string.complete));
                    }

                    @Override
                    public void onError(Throwable e) {
                        retrofitResponse.onFailureResponse(e.getMessage().toString());
                    }
                });
    }
}
