package com.apptest.interfaces

import retrofit2.Response
import java.util.*

/**
 * Created by davidpayel on 05/02/2017.
 */
interface RetrofitResponse {
    fun onComplete(message: String)
    fun onStatusResponse(response: Response<*>)
    fun onFailureResponse(message: String)
    fun onBody(): HashMap<*, *>
}
