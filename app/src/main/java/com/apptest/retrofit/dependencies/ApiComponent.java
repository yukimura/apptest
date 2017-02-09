package com.apptest.retrofit.dependencies;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Aditya on 07-May-16.
 */
@Singleton
@Component(modules = {ApiModule.class})
public interface ApiComponent {
    Retrofit retrofit();
}
