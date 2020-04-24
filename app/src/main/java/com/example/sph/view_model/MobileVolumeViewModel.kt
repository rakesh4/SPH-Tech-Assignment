package com.example.sph.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sph.database.Record
import com.example.sph.repository.MobileVolumeRepository
import com.example.sph.utility.Utils

class MobileVolumeViewModel(application: Application) : AndroidViewModel(application) {

        private var mApplication: Application = application
    internal val recordLiveData: LiveData<List<Record>>
    private val mRepository = MobileVolumeRepository(application.applicationContext)


    private val _onMessageError = MutableLiveData<Boolean>()
    val onMessageError: LiveData<Boolean> = _onMessageError

    init {
        recordLiveData = mRepository.getAllDataFromDB()
    }

    fun loadRecords() {
        if (Utils.isNetworkConnected(mApplication.applicationContext)) {
            mRepository.getRecordData()

        } else {
            _onMessageError.value = true
        }

    }


}