package com.example.sph.model


import com.example.sph.database.Record
import com.google.gson.annotations.SerializedName

class Result(
    @SerializedName("records")
    val records: List<Record>
)