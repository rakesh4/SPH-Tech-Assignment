package com.example.sph.model


import com.google.gson.annotations.SerializedName

 class MobileVolumeData(

    @SerializedName("result")
    val result: Result,
    @SerializedName("success")
    val success: Boolean
)