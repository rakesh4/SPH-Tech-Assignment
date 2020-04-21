package com.example.sph.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sph.database.AppDatabase
import com.example.sph.database.RecordEntity
import com.example.sph.model.MobileVolumeData
import com.example.sph.model.Record
import com.example.sph.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import kotlin.collections.sumByDouble as sumByDouble1


class MobileVolumeRepository(var application: Context) {

    private var call: Call<MobileVolumeData>?=null
    var record: LiveData<List<RecordEntity>>?= null
    var mDatabase: AppDatabase? = null
  //  private var mRecordDaoDao: RecordDao?
    private val mExecutor :Executor = Executors.newSingleThreadExecutor()
//    companion object {
//
//        @Volatile private var instance: MobileVolumeRepository? = null
//
//        fun  getInstance(context: Context) =
//            instance ?: synchronized(this) {
//                instance ?: MobileVolumeRepository().also { instance = it }
//            }
//
//    }

    init {
 mDatabase = AppDatabase.getDatabase(application)
   // record = getAllDataFromDB()

    // mRecordDaoDao = mDatabase?.recordDao()
    }

    fun getRecordData(){
        call= ApiClient.build()?.getRecordList("a807b7ab-6cad-4aa6-87d0-e283a7353a0f",50)
        call?.enqueue(object : Callback<MobileVolumeData> {

            override fun onResponse(call: Call<MobileVolumeData>, response: Response<MobileVolumeData>) {
                response?.body()?.let {
                    if(response.isSuccessful){
                        //todo store data in db
                        val recordData = response.body()
                        storeDataIntoDB(response.body()!!.result.records)
                    }else{
                        //todo
                        val recordData = response.body()

                    }
                }
            }

            override fun onFailure(call: Call<MobileVolumeData>, t: Throwable) {
                // todo
            }
        })


    }

     fun storeDataIntoDB(recordList: List<Record>) {
        mExecutor.execute {
            val dataList: List<RecordEntity> = ArrayList()
            var data: RecordEntity = RecordEntity(1,"abc","dfdf")
            mDatabase?.recordDao()?.insertAllRecords(recordList)
            getAllDataFromDB()
            //  mRecordDaoDao?.insertAllRecords(recordList)
        }

    }

    fun getAllDataFromDB() {
        mExecutor.execute {
            var data = mDatabase?.recordDao()?.getAllRecords("2010-Q1","2015-Q2")
            var data1 = data?.chunked(4)

            //var  data3: Double = data1?.get(0)?.get(0)?.volumeOfMobileData?.toDouble() +  data1?.get(0)?.get(1)?.volumeOfMobileData?.toDouble()
            var data4  = data1?.sumByDouble1 { it.get(0).id.toDouble() }
            var data5 = data4
        }

    //    var data1  = data.value!!

    }


}