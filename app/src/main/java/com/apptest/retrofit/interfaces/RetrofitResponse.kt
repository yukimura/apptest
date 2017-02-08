package com.apptest.retrofit.interfaces

import retrofit2.Response
import java.util.*

/**
 * Created by davidpayel on 05/02/2017.
 */
interface RetrofitResponse : RetrofitBody{
    fun onComplete(message: String)
    fun onStatusResponse(response: Response<*>)
    fun onFailureResponse(message: String)
}
