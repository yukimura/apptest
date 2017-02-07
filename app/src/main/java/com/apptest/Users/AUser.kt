package com.meetphone.monsherif.annotation.database

import android.support.annotation.IntDef

/**
 * Created by davidpayel on 05/10/2016.
 */
abstract class AUser {
    @IntDef(
            USERS.toLong(),
            USERSALBUMS.toLong(),
            GALLERYOFPICTURE.toLong()
    )
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    annotation class AUser

    companion object {
        const val USERS = 1
        const val USERSALBUMS = 2
        const val GALLERYOFPICTURE = 3
    }
}
