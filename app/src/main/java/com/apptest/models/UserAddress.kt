package com.apptest.models

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Created by davidpayel on 04/02/2017.
 */
data class UserAddress(
        val street: String? = null,
        var suite: String? = null,
        var city: String? = null,
        var zipcode: String? = null,
        var geo: ArrayList<AddressGeo>? = null) : Parcelable {

    protected constructor(parcelIn: Parcel) : this(
        street = parcelIn.readString(),
        suite = parcelIn.readString(),
        city = parcelIn.readString(),
        zipcode = parcelIn.readString(),
        geo = ArrayList<AddressGeo>()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(street)
        dest.writeString(suite)
        dest.writeString(city)
        dest.writeString(zipcode)
        dest.writeList(geo)
    }

    companion object {
        @JvmField @Suppress("unused")
        val CREATOR = createParcel { UserAddress(it) }

        inline fun <reified T : Parcelable> createParcel(
                crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
                object : Parcelable.Creator<T> {
                    override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
                    override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
                }
    }

    override fun describeContents() = 0

    override fun toString(): String {
        return "UserAddress(street=$street, suite=$suite, city=$city, zipcode=$zipcode, geo=$geo)"
    }


}