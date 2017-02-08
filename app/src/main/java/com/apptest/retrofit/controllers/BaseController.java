package com.apptest.retrofit.controllers;

import android.content.Context;

import com.apptest.R;
import com.apptest.retrofit.interfaces.RetrofitResponse;

import java.util.HashMap;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by davidpayel on 05/02/2017.
 */

public abstract class BaseController {
    protected static Context mContext;
    protected BaseController(Context context) {
        mContext = context;
    }
    protected static Context getContext() {
        return mContext;
    }

    protected RetrofitResponse mRetrofitResponse;

    protected int USERID = R.string.userId;
    protected int userId = 0;

    protected Observable<Response<Object>> mObservable;
    protected HashMap maps;

    protected void setRetrofitResponse(RetrofitResponse retrofitResponse) {
        mRetrofitResponse = retrofitResponse;
    }

    protected void observable(){
        if(mObservable != null){
            mObservable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .unsubscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<Response<Object>>() {
                        @Override
                        public void onNext(Response response) {
                            mRetrofitResponse.onStatusResponse(response);
                        }

                        @Override
                        public void onCompleted() {
                            mRetrofitResponse.onComplete(getContext().getString(R.string.complete));
                        }

                        @Override
                        public void onError(Throwable e) {
                            mRetrofitResponse.onFailureResponse(e.getMessage().toString());
                        }
                    });
        }
    }
}
