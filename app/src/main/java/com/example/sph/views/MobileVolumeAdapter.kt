package com.example.sph.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sph.R
import com.example.sph.model.Record
import com.example.sph.utility.Utils

class MobileVolumeAdapter( var recordList: List<List<Record>>?) : RecyclerView.Adapter<MobileVolumeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_records, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return recordList?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.yearTextView.text = Utils.getYearByQuarter(recordList?.get(0)?.get(0)?.quarter)

        // added 4 quarter to get yearly volume
        holder.volumeTextView.text = recordList?.sumByDouble { it.get(position).volumeOfMobileData.toDouble() }.toString()

      //  if(Utils.isVolumeDecreased(recordList?.)

    }

    fun update(records: List<List<Record>>) {
        recordList = records
        notifyDataSetChanged()


    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
       val  yearTextView: TextView = view.findViewById(R.id.tv_year)
        val volumeTextView: TextView = view.findViewById(R.id.tv_volume)
    }
}