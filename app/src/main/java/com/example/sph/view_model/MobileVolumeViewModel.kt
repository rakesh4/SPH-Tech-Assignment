package com.example.sph.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sph.model.Record
import com.example.sph.repository.MobileVolumeRepository

class MobileVolumeViewModel :ViewModel() {

    private val _record = MutableLiveData<List<Record>>().apply { value = emptyList() }
    val record: LiveData<List<Record>> = _record

    init {
        loadRecords()
    }

    private fun loadRecords() {
        val repository = MobileVolumeRepository.getInstance()
        repository.getRecordData()
    }


}