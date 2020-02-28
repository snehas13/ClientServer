package com.learn.clientserver.domain

import com.google.gson.annotations.SerializedName


data class EmpResult(
    @SerializedName("Success") val success : List<Success>
)