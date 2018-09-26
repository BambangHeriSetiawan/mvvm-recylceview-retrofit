package com.simx.mvvm.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PintroMenuItem (
        @field:SerializedName("code")
        val code: String? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("icon")
        val icon: String? = null,

        @field:SerializedName("id")
        val id: Int? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int)


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(code)
        parcel.writeString(name)
        parcel.writeString(icon)
        parcel.writeValue(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "PintroMenuItem(code=$code, name=$name, icon=$icon, id=$id)"
    }

    companion object CREATOR : Parcelable.Creator<PintroMenuItem> {
        override fun createFromParcel(parcel: Parcel): PintroMenuItem {
            return PintroMenuItem(parcel)
        }

        override fun newArray(size: Int): Array<PintroMenuItem?> {
            return arrayOfNulls(size)
        }
    }
}