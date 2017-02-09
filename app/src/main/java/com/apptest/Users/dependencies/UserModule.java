package com.apptest.Users.dependencies;

import android.content.Context;

import com.apptest.Users.annotations.AUser;
import com.apptest.main.BaseModelModule;
import com.apptest.retrofit.interfaces.RetrofitResponse;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

/**
 * Created by davidpayel on 08/02/2017.
 */

@Module
public class UserModule extends BaseModelModule {

    private UserService userService;

    public UserModule(Context context, RetrofitResponse retrofitResponse, int service) {
        this.context = context;
        this.retrofitResponse = retrofitResponse;
        this.service = service;
    }

    @Provides
    @Singleton
    Observable providesObservable(){
        retrofit();

        userService = retrofit.create(UserService.class);

        maps();

        switch (service){
            case AUser.USERS:
                observable = userService.getUsers(); //maps
                break;

            case AUser.USERSALBUMS:
                observable = userService.getUsersAlbums(userId); //maps
                break;

            case AUser.GALLERYOFPICTURE:
                observable = userService.getGalleryOfPicture(userId); //maps
                break;
        }

        observable();

        return observable;
    }
}
