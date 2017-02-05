package com.apptest.modals.database

import android.os.Parcel
import android.os.Parcelable
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

@DatabaseTable(tableName = "USER")
data class DBUser (
        @DatabaseField(columnName = "ID", generatedId = true, allowGeneratedIdInsert = true) var id: Long? = null): Parcelable {


    protected constructor(parcelIn: Parcel) : this(
            parcelIn.readLong()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(id!!)
    }

    override fun describeContents() = 0

    companion object {
        @JvmField @Suppress("unused")
        val CREATOR = createParcel { DBUser(it) }

        inline fun <reified T : Parcelable> createParcel(
                crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
                object : Parcelable.Creator<T> {
                    override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
                    override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
                }
    }
}