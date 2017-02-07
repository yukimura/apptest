package com.apptest.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by davidpayel on 04/02/2017.
 */
data class AddressGeo(
        var lat: String? = null,
        var lng: String? = null) : Parcelable {

    protected constructor(parcelIn: Parcel) : this(
        lat = parcelIn.readString(),
        lng = parcelIn.readString()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(lat)
        dest.writeString(lng)
    }

    companion object {
        @JvmField @Suppress("unused")
        val CREATOR = createParcel { AddressGeo(it) }

        inline fun <reified T : Parcelable> createParcel(
                crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
                object : Parcelable.Creator<T> {
                    override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
                    override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
                }
    }

    override fun describeContents() = 0

    override fun toString(): String {
        return "AddressGeo(lat=$lat, lng=$lng)"
    }


}