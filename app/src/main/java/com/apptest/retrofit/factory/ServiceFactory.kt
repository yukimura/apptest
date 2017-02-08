package com.apptest.retrofit.factory

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by davidpayel on 04/02/2017.
 */
object ServiceFactory {
    val PRD_API = "https://jsonplaceholder.typicode.com/"
    val STG_API = "https://jsonplaceholder.typicode.com/"
    val API_BASE_URL = STG_API

    private var httpClient: OkHttpClient.Builder? = null
    private var interceptor: Interceptor? = null

    private val builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {
        val retrofit = builder.client(client).build()
        return retrofit.create(serviceClass)
    }

    val client: OkHttpClient
        get() {
            httpClient = OkHttpClient.Builder()
            interceptor = Interceptor { chain ->
                val original = chain.request()
                val request: Request

                request = original.newBuilder()
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/json")
                        .method(original.method(), original.body())
                        .build()

                val response = chain.proceed(request)

                if (response.isSuccessful) {
                }

                response
            }
            httpClient!!.addInterceptor(interceptor)
            val client = httpClient!!.build()
            return client
        }
}