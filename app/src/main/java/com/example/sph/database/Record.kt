package com.example.sph.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "records")
class Record(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    @SerializedName("_id")
    val id: Int,

    @ColumnInfo(name = "quarter")
    @SerializedName("quarter")
    val quarter: String,

    @ColumnInfo(name = "volumeOfMobileData")
    @SerializedName("volume_of_mobile_data")
    val volumeOfMobileData: String


)