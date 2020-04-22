package com.example.sph.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sph.R
import com.example.sph.database.RecordEntity
import com.example.sph.model.Record
import com.example.sph.view_model.MobileVolumeViewModel
import kotlinx.android.synthetic.main.activity_mobile_volume.*

class MobileVolumeActivity : AppCompatActivity() {

    private lateinit var mViewModel: MobileVolumeViewModel
    private lateinit var mAdapter: MobileVolumeAdapter
    private var mRecordList: List<List<Record>>? = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_volume)
        setViewModel()
        initViews()
        setObserver()
    }

    private fun initViews() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = MobileVolumeAdapter(mRecordList)
        recyclerView.adapter = mAdapter

    }

    private fun setViewModel() {
        mViewModel = ViewModelProviders.of(this).get(MobileVolumeViewModel::class.java)
        mViewModel.loadRecords()
    }

    private fun setObserver() {
        mViewModel._record.observe(this,recordListObserver)
//        mViewModel._record.observe(this, object : Observer<List<Record>> {
//            override fun onChanged(t: List<Record>) {
//                setAdapter()
//
//            }
//        });
    }

    private val recordListObserver = Observer<List<Record>>{
        mRecordList = it.chunked(4)
        mAdapter.update(mRecordList!!)

    }


}