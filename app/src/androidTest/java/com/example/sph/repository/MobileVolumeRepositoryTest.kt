package com.example.sph.repository

import android.app.Application
import com.example.sph.database.AppDatabase
import com.example.sph.database.RecordDao
import com.example.sph.utility.Constants
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.Spy

class MobileVolumeRepositoryTest {


//    @Mock
//    private lateinit var context: Application
//
//    @Spy
//    private lateinit var repository: MobileVolumeRepository
//
//    private var mDatabase: AppDatabase? = null
//    private lateinit var mRecordDao: RecordDao
//
//    @Before
//    fun setUp() {
//        MockitoAnnotations.initMocks(this)
//        mDatabase = AppDatabase.getDatabase(context)
//        mRecordDao = mDatabase?.recordDao()!!
//    }
//
//    @After
//    fun tearDown() {
//    }
//
//    @Test
//    fun getRecordData() {
//
//
//    }
//
//    @Test
//    fun storeDataIntoDB() {
//    }
//
//    @Test
//    fun getAllDataFromDB() {
//        `when`(repository.getAllDataFromDB()).thenReturn(repository.getAllDataFromDB())
//    }
}