package com.apptest.retrofit.singletons

import android.app.Application

import com.apptest.core.CoreApp
import com.apptest.database.controllers.ExceptionController
import com.apptest.retrofit.controllers.BaseController
import com.apptest.Users.controllers.UserController

/**
 * Created by davidpayel on 05/02/2017.
 */

class ServiceManager(application: CoreApp) : BaseController(application.applicationContext) {
    protected var mUserController: UserController

    init {
        mUserController = UserController(BaseController.getContext())
    }

    /**
     * Access to other controllers
     * @return
     * *
     * @throws ExceptionController
     */

    val userController: UserController
        @Throws(ExceptionController::class)
        get() = mInstance!!.mUserController

    companion object {
        private var mInstance: ServiceManager? = null

        fun getInstance(application: Application?): ServiceManager {
            if (null == mInstance && application != null && application is CoreApp) {
                mInstance = ServiceManager(application)
            }
            return mInstance!!
        }
    }
}
