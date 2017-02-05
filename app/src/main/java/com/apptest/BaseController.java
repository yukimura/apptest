package com.apptest;

import android.content.Context;

import com.apptest.interfaces.RetrofitResponse;

/**
 * Created by davidpayel on 05/02/2017.
 */

public abstract class BaseController {
    protected static Context mContext;
    protected BaseController(Context context) {
        mContext = context;
    }
    protected static Context getContext() {
        return mContext;
    }

    protected RetrofitResponse mRetrofitResponse;

    protected void setRetrofitResponse(RetrofitResponse retrofitResponse) {
        mRetrofitResponse = retrofitResponse;
    }
}
