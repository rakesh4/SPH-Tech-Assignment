package com.example.sph.view_model

import android.content.Context
import androidx.lifecycle.Observer
import androidx.test.InstrumentationRegistry
import com.example.sph.database.AppDatabase
import com.example.sph.database.Record
import com.example.sph.database.RecordDao
import com.example.sph.repository.MobileVolumeRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations


class MobileVolumeViewModelTest {



    private lateinit var recordListObserver:Observer<List<Record>>

    private lateinit var viewModel:MobileVolumeViewModel

    @Mock
    private lateinit var repository: MobileVolumeRepository

    @Mock
    private lateinit var database: AppDatabase

    @Mock
    private lateinit var  mRecordDao: RecordDao



//    @Before
//    fun init() {
//        MockitoAnnotations.initMocks(this)
//    }



    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getTargetContext()

        database = AppDatabase.getDatabase(appContext)!!
        mRecordDao = database.recordDao()
       // viewModel= MobileVolumeViewModel(Mockito.mock(Application::class.java))
        repository =MobileVolumeRepository(appContext)



        //setupObservers()
    }

    @Test
    fun retrieve(){
         doNothing().`when`(repository.getRecordData())


    }




    private fun setupObservers(){
        recordListObserver= mock(Observer::class.java) as Observer<List<Record>>
    }
}