package com.apptest.singleton;

import android.app.Application;

import com.apptest.BaseController;
import com.apptest.CoreApp;
import com.apptest.controllers.ExceptionController;
import com.apptest.controllers.RetrofitController;

/**
 * Created by davidpayel on 05/02/2017.
 */

public class AppManager extends BaseController {
    private static AppManager mInstance;
    protected RetrofitController mRetrofitController;

    public AppManager(CoreApp application) {
        super(application.getApplicationContext());
        mRetrofitController = new RetrofitController(getContext());
    }

    public static AppManager getInstance(Application application){
        if(null == mInstance && application != null && application instanceof CoreApp) {
            mInstance = new AppManager((CoreApp) application);
        }
        return mInstance;
    }

    /**
     * Access to other controllers
     * @return
     * @throws ExceptionController
     */

    public final RetrofitController getRetrofitController() throws ExceptionController {
        return mInstance.mRetrofitController;
    }
}
