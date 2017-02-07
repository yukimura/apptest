package com.apptest.Users

import android.util.Log
import com.apptest.CoreApp
import com.apptest.R
import com.apptest.interfaces.RetrofitResponse
import com.apptest.models.User
import com.apptest.singleton.AppManager
import retrofit2.Response
import java.util.*

/**
 * Created by davidpayel on 07/02/2017.
 */

class UserPresenter(usersView: UserContract.View) : UserContract.Presenter, RetrofitResponse {
    companion object {
        val TAG = UserPresenter::class.java.simpleName
    }

    private val mUsersView: UserContract.View
    private var users: ArrayList<User>? = null

    init {
        mUsersView = checkNotNull(usersView)
        mUsersView.setPresenter(this)
    }

    override fun start(service: Int) {
        load(service)
    }

    override fun load(service: Int) {
        mUsersView.showProgressIndicator()
        AppManager.getInstance(CoreApp.APPLICATION).getRetrofitController().retrofit(this, service)
    }

    override fun onComplete(message: String) {
        Log.i(TAG, message)
        if (!users?.isEmpty()!!) {
            mUsersView.showUsers(users!!)
        } else {
            mUsersView.showMessage(R.string.default_info_message)
        }
    }

    override fun onStatusResponse(response: Response<*>) {
        val responseUser = response as Response<ArrayList<User>>
        this@UserPresenter.users = responseUser.body()
    }

    override fun onFailureResponse(message: String) {
        Log.e(TAG, message)
    }

    override fun onBody(): HashMap<*, *> {
        val maps = HashMap<String, String>()
        return maps
    }
}
