package com.apptest.presenter

/**
 * Created by davidpayel on 04/02/2017.
 */

interface Presenter<V> {
    fun attachView(view: V)
    fun detachView()
}
