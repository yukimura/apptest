package com.apptest.view

import android.support.v7.app.AppCompatActivity

import com.apptest.model.User
import java.util.*

/**
 * Created by davidpayel on 04/02/2017.
 */

interface MainView {
    fun showUsers(users: ArrayList<User>)

    fun showMessage(stringId: Int)

    fun showProgressIndicator()
}
