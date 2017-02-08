package com.apptest.Users.services;

import com.apptest.Users.models.User;

import java.util.ArrayList;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by davidpayel on 04/06/16.
 */
public interface UserService {

    @GET("/users")
    Observable<Response<ArrayList<User>>> getUsers(); //@Body HashMap maps

    @POST("/users/{user_id}/albums")
    Observable<Response<ArrayList<Object>>> getUsersAlbums(@Path("userId") long userId); //@Body HashMap maps

    @POST("/albums/{album_id}/photos")
    Observable<Response<ArrayList<Object>>> getGalleryOfPicture(@Path("albumId") long userId); //@Body HashMap maps
}
