package com.example.sph.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sph.R
import com.example.sph.model.Record
import com.example.sph.view_model.MobileVolumeViewModel

class MobileVolumeActivity : AppCompatActivity() {

    private lateinit var mViewModel: MobileVolumeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_volume)

        setViewModel()
        setObserver()
    }

    private fun setViewModel() {
        mViewModel = ViewModelProviders.of(this).get(MobileVolumeViewModel::class.java)
    }

    private fun setObserver() {
        mViewModel.record.observe(this,recordListObserver)
    }

    private val recordListObserver = Observer<List<Record>>{
        // todo set adapter
        Log.d("Record list", ""+it )
    }
}