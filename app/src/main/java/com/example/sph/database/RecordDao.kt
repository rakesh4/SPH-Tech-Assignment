package com.example.sph.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sph.model.Record

@Dao
interface RecordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllRecords(recordEntities: List<Record>)

    @Query("SELECT * from records WHERE quarter BETWEEN :start AND :end")
    fun getAllRecords(start:String, end:String): LiveData<List<Record>>
}