package com.apptest.Users.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by davidpayel on 04/02/2017.
 */
data class UserCompany(
        val name: String? = null,
        val catchPhrase: String? = null,
        val bs: String? = null) : Parcelable {

    protected constructor(parcelIn: Parcel) : this(
        name = parcelIn.readString(),
        catchPhrase = parcelIn.readString(),
        bs = parcelIn.readString()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(catchPhrase)
        dest.writeString(bs)
    }

    companion object {
        @JvmField @Suppress("unused")
        val CREATOR = createParcel { UserCompany(it) }

        inline fun <reified T : Parcelable> createParcel(
                crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
                object : Parcelable.Creator<T> {
                    override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
                    override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
                }
    }

    override fun describeContents() = 0
}