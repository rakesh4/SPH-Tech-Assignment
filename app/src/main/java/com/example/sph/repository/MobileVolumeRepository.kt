package com.example.sph.repository

import com.example.sph.model.MobileVolumeData
import com.example.sph.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MobileVolumeRepository {

    private var call: Call<MobileVolumeData>?=null
    companion object {

        @Volatile private var instance: MobileVolumeRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: MobileVolumeRepository().also { instance = it }
            }
    }

    fun getRecordData(){
        call= ApiClient.build()?.getRecordList("a807b7ab-6cad-4aa6-87d0-e283a7353a0f",5)
        call?.enqueue(object : Callback<MobileVolumeData> {

            override fun onResponse(call: Call<MobileVolumeData>, response: Response<MobileVolumeData>) {
                response?.body()?.let {
                    if(response.isSuccessful){
                        //todo store data in db
                        val recordData = response.body()
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
}