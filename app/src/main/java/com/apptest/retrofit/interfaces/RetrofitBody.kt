package com.apptest.retrofit.interfaces

import java.util.HashMap

/**
 * Created by davidpayel on 04/06/16.
 */
interface RetrofitBody {
    fun onBody(service: Int): HashMap<*, *>
}
