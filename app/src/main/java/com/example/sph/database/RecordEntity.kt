package com.example.sph.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "record_table")
data class RecordEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var id:Int,

    @ColumnInfo(name = "quarter")
    var quarter: String,

    @ColumnInfo(name = "volumeOfMobileData")
    var volumeOfMobileData: String



)