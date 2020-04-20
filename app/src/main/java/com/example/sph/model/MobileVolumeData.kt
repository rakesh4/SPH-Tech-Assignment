package com.example.sph.model


import com.google.gson.annotations.SerializedName

data class MobileVolumeData(
    @SerializedName("help")
    val help: String,
    @SerializedName("result")
    val result: Result,
    @SerializedName("success")
    val success: Boolean
)