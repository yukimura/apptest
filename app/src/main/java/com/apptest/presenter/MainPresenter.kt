package com.apptest.presenter

import android.support.annotation.Nullable
import android.util.Log
import com.apptest.CoreApp
import com.apptest.R
import com.apptest.interfaces.RetrofitResponse
import com.apptest.model.User
import com.apptest.singleton.AppManager
import com.apptest.view.MainView
import retrofit2.Response
import java.util.*

/**
 * Created by davidpayel on 04/02/2017.
 */

class MainPresenter : Presenter<MainView>, RetrofitResponse {
    companion object {
        val TAG = MainPresenter::class.java.simpleName
    }

    private var mainView: MainView? = null
    private var users: ArrayList<User>? = null

    protected var APP_SERVICE = 0

    override fun attachView(view: MainView) {
        this.mainView = view
    }

    override fun detachView() {
        this.mainView = null
    }

    override fun onComplete(message: String?) {
        Log.i(TAG, message)
        if (!users?.isEmpty()!!) {
            mainView?.showUsers(users!!)
        } else {
            mainView?.showMessage(R.string.default_info_message)
        }
    }

    override fun onStatusResponse(response: Response<*>?) {
        val responseUser = response as Response<ArrayList<User>>
        this@MainPresenter.users = responseUser.body()
    }

    override fun onFailureResponse(message: String?) {
        Log.e(TAG, message)
    }

    fun loadUers(appService: Int, userId: Long) {

        mainView?.showProgressIndicator()

        if (appService != null) {
            AppManager.getInstance(CoreApp.APPLICATION).getRetrofitController().retrofit(this, appService, userId)
        }
    }
}
