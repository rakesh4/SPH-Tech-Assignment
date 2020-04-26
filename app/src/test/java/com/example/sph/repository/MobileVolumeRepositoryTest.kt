package com.example.sph.repository

import android.content.Context
import com.example.sph.database.AppDatabase
import com.example.sph.database.Record
import com.example.sph.database.RecordDao
import com.example.sph.network.ApiClient
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.After
import org.junit.Before
import org.junit.Test


class MobileVolumeRepositoryTest {


    private lateinit var repository: MobileVolumeRepository
    private lateinit var mContextMock: Context

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        mContextMock = mockk<Context>(relaxed = true)
        repository = spyk(MobileVolumeRepository(mContextMock))
    }

    @Test
    fun test_verify_method_getRecordData(){
        repository.getRecordData()
        verify {  repository.getRecordData() }
        confirmVerified(repository)
    }

    @Test
    fun test_verify_method_getAllDataFromDB() {
        repository.getAllDataFromDB()
        verify {  repository.getAllDataFromDB() }
        confirmVerified(repository)
    }


}