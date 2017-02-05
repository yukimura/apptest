package com.apptest.controllers;

import android.content.Context;

import com.apptest.BaseController;
import com.apptest.R;
import com.apptest.interfaces.AppService;
import com.apptest.interfaces.RetrofitResponse;
import com.apptest.model.User;
import com.apptest.retrofit.FactoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitController extends BaseController {
    public Long mUserId;

    public RetrofitController(Context context) {
        super(context);
    }

    public void retrofit(RetrofitResponse retrofitResponse, int switchId, Long userId){
        mUserId = userId;
        setRetrofitResponse(retrofitResponse);
        Observable<Response<ArrayList<Object>>> observable = switchObservable(switchId);

        if(observable != null){
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .unsubscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<Response<ArrayList<Object>>>() {
                        @Override
                        public void onCompleted() {
                            mRetrofitResponse.onComplete(getContext().getString(R.string.complete));
                        }

                        @Override
                        public void onError(Throwable e) {
                            mRetrofitResponse.onFailureResponse(e.getMessage().toString());
                        }

                        @Override
                        public void onNext(Response response) {
                            mRetrofitResponse.onStatusResponse(response);
                        }
                    });
        }
    }

    public Observable switchObservable(int switchId){
        AppService appService = FactoryService.INSTANCE.createService(AppService.class);
        switch (switchId){
            /**
             * Users
             */
            case 1:
                return appService.getUsers();

            /**
             * UsersAlbums
             */
            case 2:
                return appService.getUsersAlbums(mUserId);

            /**
             * GalleryOfPicture
             */
            case 3:
                return appService.getGalleryOfPicture(mUserId);

        }
        return null;
    }
}
