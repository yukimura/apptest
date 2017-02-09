package com.apptest.main.interfaces

/**
 * Created by davidpayel on 07/02/2017.
 */

interface BaseView<in T : BasePresenter> {
    fun setPresenter(presenter: T)

}
