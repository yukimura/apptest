package com.apptest.Users.models

import android.os.Parcel
import android.os.Parcelable
import java.util.*
import com.apptest.Users.models.UserAddress
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

/**
 * Created by davidpayel on 04/02/2017.
 */
data class User(
        val id: Long? = null,
        var name: String? = null,
        var username: String? = null,
        var email: String? = null,
        var address: UserAddress? = null,
        var phone: String? = null,
        var website: String? = null,
        var company: UserCompany? = null) : Parcelable {

    protected constructor(parcelIn: Parcel) : this(
        id = parcelIn.readLong(),
        name = parcelIn.readString(),
        username = parcelIn.readString(),
        email = parcelIn.readString(),
        address = parcelIn.readParcelable<UserAddress>(UserAddress::class.java.classLoader),
        phone = parcelIn.readString(),
        website = parcelIn.readString(),
        company = parcelIn.readParcelable<UserCompany>(UserCompany::class.java.classLoader)
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(id!!)
        dest.writeString(name)
        dest.writeString(username)
        dest.writeParcelable(address, flags)
        dest.writeString(phone)
        dest.writeString(website)
        dest.writeParcelable(company, flags)
    }

    companion object {
        @JvmField @Suppress("unused")
        val CREATOR = createParcel { User(it) }

        inline fun <reified T : Parcelable> createParcel(
                crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
                object : Parcelable.Creator<T> {
                    override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
                    override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
                }
    }

    override fun describeContents() = 0

    override fun toString(): String {
        return "User(id=$id, name=$name, username=$username, email=$email, address=$address, phone=$phone, website=$website, company=$company)"
    }


}