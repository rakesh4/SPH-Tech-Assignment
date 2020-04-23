package com.example.sph.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sph.R
import com.example.sph.database.Record
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
        mViewModel.recordLiveData.observe(this,recordListObserver)
        mViewModel.onMessageError.observe(this,errorMessageObserver)
        mAdapter.onQuarterDetail.observe(this,quarterDetailObserver)

    }

    private val recordListObserver = Observer<List<Record>>{
        if (it.isNotEmpty()) {
            progressBar.hide()
            mRecordList = it.chunked(4)
            mAdapter.update(mRecordList!!)
        }



    }

    @SuppressLint("ShowToast")
    private val errorMessageObserver = Observer<Boolean> {
        if(it) Toast.makeText(this, R.string.no_internet_connection_text, Toast.LENGTH_LONG).show()
        progressBar.hide()
    }

    private val quarterDetailObserver = Observer<String>{
       showQuarterDetail(it)


    }

    private fun showQuarterDetail(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.alert_title_text)
        builder.setMessage(message)
        builder.setPositiveButton(R.string.ok) { dialog, _ ->
          dialog.dismiss()
        }
        builder.show()
    }


}