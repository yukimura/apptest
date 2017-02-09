package com.apptest.Users

import android.content.Context
import android.util.Log
import com.apptest.core.CoreApp
import com.apptest.R
import com.apptest.Users.annotations.AUser
import com.apptest.Users.annotations.AUser.Companion.GALLERYOFPICTURE
import com.apptest.Users.annotations.AUser.Companion.USERS
import com.apptest.Users.annotations.AUser.Companion.USERSALBUMS
import com.apptest.Users.dependencies.DaggerUserComponent
import com.apptest.retrofit.interfaces.RetrofitResponse
import com.apptest.Users.models.User
import com.apptest.Users.dependencies.UserModule
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

    override fun start() {
        load(AUser.USERS)
    }

    override fun load(service: Int) {
        mUsersView.showProgressIndicator()

        DaggerUserComponent.builder()
                .userModule(UserModule(CoreApp.APPLICATION, this, service))
                .build().observable()

        //ServiceManager.getInstance(CoreApp.APPLICATION).userController.users(this, service)
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
        this@UserPresenter.users = response.body() as ArrayList<User>
    }

    override fun onFailureResponse(message: String) {
        Log.e(TAG, message)
    }

    override fun onBody(service: Int): HashMap<*, *> {
        var maps = HashMap<String, String>()
        when (service) {
            USERS -> return maps
            USERSALBUMS -> return maps
            GALLERYOFPICTURE -> return maps
        }
        return maps
    }
}
