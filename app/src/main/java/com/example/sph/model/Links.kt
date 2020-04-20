package com.example.sph.model


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("next")
    val next: String,
    @SerializedName("start")
    val start: String
)