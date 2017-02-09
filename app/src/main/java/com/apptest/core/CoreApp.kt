package com.apptest.core

import android.app.Application
import butterknife.ButterKnife

/**
 * Created by davidpayel on 04/02/2017.
 */

class CoreApp : Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    fun init() {
        APPLICATION = this
        ButterKnife.setDebug(true)
    }

    companion object {
        var APPLICATION: Application? = null
    }
}
