package com.apptest.retrofit.dependencies;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.apptest.BuildConfig;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by davidpayel on 08/02/2017.
 */

@Module
public class ApiModule {

    String API_URL;

    public ApiModule() {
        if (BuildConfig.DEBUG == true) {
            API_URL = "https://jsonplaceholder.typicode.com/";
        } else if (BuildConfig.DEBUG == false) {
            API_URL = "https://jsonplaceholder.typicode.com/";
        }
    }

    @Provides
    @Singleton
    Interceptor providesInterceptor(){
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/json")
                        .method(original.method(), original.body())
                        .build();

                Response response = chain.proceed(request);
                if (response.isSuccessful()) {}

                return response;
            }
        };
        return interceptor;
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClientInterceptor(Interceptor interceptor) {
        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder();
        httpClient.addInterceptor(interceptor);
        OkHttpClient client = httpClient.build();
        return client;
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }
}
