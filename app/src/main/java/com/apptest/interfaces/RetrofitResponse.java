package com.apptest.interfaces;

import retrofit2.Response;

/**
 * Created by davidpayel on 05/02/2017.
 */
public interface RetrofitResponse {
    void onComplete(String message);
    void onStatusResponse(Response response);
    void onFailureResponse(String message);
}
