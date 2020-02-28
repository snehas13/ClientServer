package com.learn.clientserver.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Success(
    @SerializedName("id") var id : Int,
    @SerializedName("name") var name : String,
    @SerializedName("category") var category : String,
    @SerializedName("categoryid") var categoryid : Int,
    @SerializedName("address") var address : String,
    @SerializedName("description") var description : String,
    @SerializedName("contact") var contact : String,
    @SerializedName("empcode") var empcode : String,
    @SerializedName("image") var image : String
) : Parcelable