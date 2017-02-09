package com.apptest.adapter

import android.content.Context
import com.apptest.database.DatabaseHelper


/**
 * Created by davidpayel on 06/10/2016.
 */

open class BaseHelperController protected constructor(context: Context) {
    var helper: DatabaseHelper = DatabaseHelper(context)
}
