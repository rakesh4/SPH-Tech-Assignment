package com.example.sph.network

import com.example.sph.model.MobileVolumeData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApiInterface {

    @GET("datastore_search")
    fun getRecordList(
        @Query("resource_id") resourceId: String, @Query("limit") pageSize: Int): Call<MobileVolumeData>
}