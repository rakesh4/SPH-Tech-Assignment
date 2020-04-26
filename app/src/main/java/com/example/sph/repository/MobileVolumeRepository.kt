package com.example.sph.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sph.database.AppDatabase
import com.example.sph.database.RecordDao
import com.example.sph.model.MobileVolumeData
import com.example.sph.database.Record
import com.example.sph.network.ApiClient
import com.example.sph.utility.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor
import java.util.concurrent.Executors


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MobileVolumeRepository(application: Context) {

    private val recordLiveData: LiveData<List<Record>>
    private var mDatabase: AppDatabase? = null
    private val mRecordDao: RecordDao
    private val mExecutor: Executor = Executors.newSingleThreadExecutor()

    init {
        mDatabase = AppDatabase.getDatabase(application)
        mRecordDao = mDatabase?.recordDao()!!
        recordLiveData = mRecordDao.getAllRecords(Constants.START_DATA, Constants.END_DATA)
    }

    // fetch volume of mobile records through API
    fun getRecordData() {
        val call = ApiClient.build()?.getRecordList(Constants.RESOURCE_ID, Constants.PAGE_SIZE)
        call?.enqueue(object : Callback<MobileVolumeData> {

            override fun onResponse(
                call: Call<MobileVolumeData>,
                response: Response<MobileVolumeData>
            ) {
                response.body()?.let {
                    if (response.isSuccessful && response.body()!!.success) {
                        storeDataIntoDB(response.body()!!.result.records)
                    }
                }
            }

            override fun onFailure(call: Call<MobileVolumeData>, t: Throwable) {
                Log.d("Repository", t.message)
            }
        })
    }

    // insert data into local db
    fun storeDataIntoDB(recordList: List<Record>) {
        mExecutor.execute {
            mDatabase?.recordDao()?.insertAllRecords(recordList)
        }

    }

    // get data from local db
    fun getAllDataFromDB(): LiveData<List<Record>> {
        return recordLiveData
    }

}