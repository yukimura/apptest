package com.apptest.controllers;

import android.content.Context;

import com.apptest.BaseController;
import com.apptest.R;
import com.apptest.interfaces.AppService;
import com.apptest.interfaces.RetrofitResponse;
import com.apptest.retrofit.FactoryService;
import com.meetphone.monsherif.annotation.database.AUser;

import java.util.HashMap;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by davidpayel on 07/02/2017.
 */

public class RetrofitController extends BaseController {
    private int USERID = R.string.userId;
    private int userId = 0;

    public RetrofitController(Context context) {
        super(context);
    }

    public void retrofit(RetrofitResponse retrofitResponse, int service){
        setRetrofitResponse(retrofitResponse);
        Observable<Response<Object>> observable = switchObservable(service);

        if(observable != null){
            observable.subscribeOn(Schedulers.io())
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

    public Observable switchObservable(int service){
        AppService appService = FactoryService.INSTANCE.createService(AppService.class);
        HashMap maps = mRetrofitResponse.onBody();
        if(maps.get(USERID) != null){
            userId = Integer.parseInt(maps.get(USERID).toString());
            maps.remove(USERID);
        }
        switch (service){
            case AUser.USERS:
                return appService.getUsers(); //maps

            case 2:
                return appService.getUsersAlbums(userId); //maps

            case 3:
                return appService.getGalleryOfPicture(userId); //maps
        }
        return null;
    }
}