package com.apptest.interfaces;

import com.apptest.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by davidpayel on 04/06/16.
 */
public interface AppService {

    @GET("/users")
    Observable<Response<ArrayList<Object>>> getUsers();

    @POST("/users/{user_id}/albums")
    Observable<Response<ArrayList<Object>>> getUsersAlbums(@Path("userId") long userId);

    @POST("/albums/{album_id}/photos")
    Observable<Response<ArrayList<Object>>> getGalleryOfPicture(@Path("userId") long userId);
}
