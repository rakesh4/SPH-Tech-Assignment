package com.example.sph.view_model

import android.app.Application
import android.content.Context
import com.example.sph.repository.MobileVolumeRepository
import io.mockk.*
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before

import org.junit.Test

class MobileVolumeViewModelTest {

    private lateinit var viewModel:MobileVolumeViewModel

    private lateinit var context: Application

    private lateinit var repository: MobileVolumeRepository


    @Before
    fun setUp() {

        MockKAnnotations.init(this, relaxUnitFun = true)
        context = mockk<Application>(relaxed = true)
        repository = spyk(MobileVolumeRepository(context.applicationContext))
    }

    @Test
    fun test_verify_method_getAllDataFromDB(){
        repository.getAllDataFromDB()
        verify {  repository.getAllDataFromDB() }
        confirmVerified(repository)
    }





}