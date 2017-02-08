package com.apptest.Users

import com.apptest.core.interfaces.BasePresenter
import com.apptest.core.interfaces.BaseView
import com.apptest.Users.models.User
import java.util.*

/**
 * Created by davidpayel on 07/02/2017.
 */

interface UserContract {
    interface View : BaseView<Presenter> {
        fun showUsers(users: ArrayList<User>)
        fun showMessage(resStringId: Int)
        fun showProgressIndicator()
    }

    interface Presenter : BasePresenter {
        fun load(service: Int)
    }
}
