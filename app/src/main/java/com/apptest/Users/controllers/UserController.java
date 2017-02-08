package com.apptest.Users.controllers;

import android.content.Context;

import com.apptest.Users.annotations.AUser;
import com.apptest.Users.services.UserService;
import com.apptest.retrofit.interfaces.RetrofitResponse;
import com.apptest.retrofit.controllers.BaseController;
import com.apptest.retrofit.factory.ServiceFactory;

import rx.Observable;

/**
 * Created by davidpayel on 07/02/2017.
 */

public class UserController extends BaseController {

    public UserController(Context context) {
        super(context);
    }

    public void users(RetrofitResponse retrofitResponse, int service){
        setRetrofitResponse(retrofitResponse);
        mObservable = switchObservable(service);
        observable();
    }

    public Observable switchObservable(int service){
        UserService userService = ServiceFactory.INSTANCE.createService(UserService.class);
        maps = mRetrofitResponse.onBody(service);
        setAndRemoveUserId();
        switch (service){
            case AUser.USERS:
                return userService.getUsers(); //maps

            case AUser.USERSALBUMS:
                return userService.getUsersAlbums(userId); //maps

            case AUser.GALLERYOFPICTURE:
                return userService.getGalleryOfPicture(userId); //maps
        }
        return null;
    }

    public void setAndRemoveUserId(){
        if(maps.get(USERID) != null){
            userId = Integer.parseInt(maps.get(USERID).toString());
            maps.remove(USERID);
        }
    }
}