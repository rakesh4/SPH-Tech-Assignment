package com.example.sph.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.sph.R
import com.example.sph.database.Record
import com.example.sph.utility.Utils

class MobileVolumeAdapter(private var recordList: List<List<Record>>?) :
    RecyclerView.Adapter<MobileVolumeAdapter.ViewHolder>() {

    private val _onQuarterDetail = MutableLiveData<String>()
    val onQuarterDetail: LiveData<String> = _onQuarterDetail

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_records, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recordList?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val records = recordList?.get(position)

        holder.yearTextView.text = Utils.getYearByQuarter(records?.get(0)?.quarter)

        // addition of 4 quarter to get yearly volume
        holder.volumeTextView.text = Utils.getYearlyVolume(records)


        // Display image if any quarter decreased in the year
        if (Utils.isVolumeDecreased(records)) {
            holder.decreaseVolumeImageView.visibility = View.VISIBLE
        }else{
            holder.decreaseVolumeImageView.visibility = View.GONE
        }

        holder.decreaseVolumeImageView.setOnClickListener {
            _onQuarterDetail.value = Utils.getDecreasedVolumeDetail(records)
        }
    }

    fun update(records: List<List<Record>>) {
        recordList = records
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val yearTextView: TextView = view.findViewById(R.id.tv_year)
        val volumeTextView: TextView = view.findViewById(R.id.tv_volume)
        val decreaseVolumeImageView: ImageView = view.findViewById(R.id.iv_decrease)
    }
}