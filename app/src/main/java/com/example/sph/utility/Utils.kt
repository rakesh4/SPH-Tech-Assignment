package com.example.sph.utility

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.sph.database.Record


@Suppress("DEPRECATION", "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
object Utils {

    // get year by substring quarter
    fun getYearByQuarter(quarter: String?) = "Year - " + quarter?.substringBeforeLast("-")


    // get total volume of Year though addition of quarters
    fun getYearlyVolume(record: List<Record>?) =
        "Total Volume - " + record?.sumByDouble { it.volumeOfMobileData.toDouble() }.toString()


    // checks volume decreased or not of quarters in the year
    fun isVolumeDecreased(record: List<Record>?): Boolean {
        return record!![0].volumeOfMobileData.toDouble() > record[1].volumeOfMobileData.toDouble() ||
                record[1].volumeOfMobileData.toDouble() > record[2].volumeOfMobileData.toDouble() ||
                record[2].volumeOfMobileData.toDouble() > record[3].volumeOfMobileData.toDouble()

    }

    // get decreased quarter with volume to display on dialog
    fun getDecreasedVolumeDetail(record: List<Record>?): String? {
        when {
            record!![0].volumeOfMobileData.toDouble() > record[1].volumeOfMobileData.toDouble() -> {
                return record[1].quarter + " has less volume as compare with " + record[0].quarter + "\n\n" + record[0].quarter + " - " + record[0].volumeOfMobileData + "\n" + record[1].quarter + " - " + record[1].volumeOfMobileData
            }
            record[1].volumeOfMobileData.toDouble() > record[2].volumeOfMobileData.toDouble() -> {
                return record[2].quarter + " has less volume as compare with " + record[1].quarter + "\n\n" + record[1].quarter + " - " + record[1].volumeOfMobileData + "\n" + record[2].quarter + " - " + record[2].volumeOfMobileData

            }
            record[2].volumeOfMobileData.toDouble() > record[3].volumeOfMobileData.toDouble() -> {
                return record[3].quarter + " has less volume as compare with " + record[2].quarter + "\n\n" + record[2].quarter + " - " + record[2].volumeOfMobileData + "\n" + record[3].quarter + " - " + record[3].volumeOfMobileData

            }
            else -> {
                return null
            }
        }

    }

    // check internet connection
    fun isNetworkConnected(context: Context): Boolean {
        val cm =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT < 23) {
            val ni = cm.activeNetworkInfo
            if (ni != null) {
                return ni.isConnected && (ni.type == ConnectivityManager.TYPE_WIFI || ni.type == ConnectivityManager.TYPE_MOBILE)
            }
        } else {
            val n = cm.activeNetwork
            if (n != null) {
                val nc = cm.getNetworkCapabilities(n)
                return nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(
                    NetworkCapabilities.TRANSPORT_WIFI
                )
            }
        }
        return false
    }


}