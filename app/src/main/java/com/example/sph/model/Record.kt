package com.example.sph.model


import com.google.gson.annotations.SerializedName

data class Record(
    @SerializedName("_id")
    val id: Int,
    @SerializedName("quarter")
    val quarter: String,
    @SerializedName("volume_of_mobile_data")
    val volumeOfMobileData: String
)