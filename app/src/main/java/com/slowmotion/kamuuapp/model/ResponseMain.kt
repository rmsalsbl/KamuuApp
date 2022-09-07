package com.slowmotion.kamuuapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseMain (

        @field:SerializedName("Name")
        val Name : String? = null,

        @field:SerializedName("Price")
        val Price : String? = null,

        @field:SerializedName("Description")
        val Description : String? = null,

        @field:SerializedName("Picture")
        val Picture : String? = null



) : Parcelable