package com.example.sph.utility

import com.example.sph.R
import com.example.sph.model.Record

class Utils {

    companion object {


        fun getYearByQuarter(quarter: String?) = "Year "+ quarter?.substringBeforeLast("-")

        fun getTotalYearValume(record: List<Record>?) = record?.sumByDouble1 { it.get(0).id.toDouble() }




    }

}