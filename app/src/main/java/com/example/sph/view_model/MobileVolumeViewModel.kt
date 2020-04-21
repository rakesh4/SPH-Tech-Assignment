package com.example.sph.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sph.database.RecordEntity
import com.example.sph.model.Record
import com.example.sph.repository.MobileVolumeRepository

class MobileVolumeViewModel(application: Application) :AndroidViewModel(application) {


    private var _record: LiveData<List<RecordEntity>>? = null
    val record: LiveData<List<RecordEntity>>? = _record

    init {
        val repository = MobileVolumeRepository(application.applicationContext)
        repository.getRecordData()
        _record = repository.record

        repository.getAllDataFromDB()


       // loadRecords()
    }

    private fun loadRecords() {
    }


}