package com.apptest.adapter

import android.content.Context
import com.apptest.BaseController
import com.apptest.database.DatabaseHelper


/**
 * Created by davidpayel on 06/10/2016.
 */

open class BaseHelperController protected constructor(context: Context) : BaseController(context) {
    var helper: DatabaseHelper = DatabaseHelper(context)
}
