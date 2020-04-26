package com.example.sph.utility

import com.example.sph.database.Record
import io.mockk.mockkObject
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UtilsTest {

    @Before
    fun setUp() {
        mockkObject(Utils)
    }

    @Test
    fun getYearByQuarter() {
        Assert.assertEquals("Year - 2009", Utils.getYearByQuarter("2009-Q1"))
    }

    @Test
    fun isVolumeDecreasedSuccess() {
        val recordList: MutableList<Record> = mutableListOf()
        recordList.add(Record(1, "2009-Q1", "0.1212e23"))
        recordList.add(Record(2, "2009-Q2", "0.3412e23"))
        recordList.add(Record(3, "2009-Q3", "0.4212e23"))
        recordList.add(Record(4, "2009-Q4", "0.3112e23"))

        Assert.assertEquals(true, Utils.isVolumeDecreased(recordList))
    }

    @Test
    fun isVolumeDecreasedFailed() {
        val recordList: MutableList<Record> = mutableListOf()
        recordList.add(Record(1, "2009-Q1", "0.1212e23"))
        recordList.add(Record(2, "2009-Q2", "0.3412e23"))
        recordList.add(Record(3, "2009-Q3", "0.4212e23"))
        recordList.add(Record(4, "2009-Q4", "0.5112e23"))

        Assert.assertEquals(false, Utils.isVolumeDecreased(recordList))
    }

    @Test
    fun getDecreasedVolumeQuarter2() {

        val recordList: MutableList<Record> = mutableListOf()
        recordList.add(Record(1, "2009-Q1", "0.2212e23"))
        recordList.add(Record(2, "2009-Q2", "0.1412e23"))
        recordList.add(Record(3, "2009-Q3", "0.4212e23"))
        recordList.add(Record(4, "2009-Q4", "0.5112e23"))

        val quarter2 =
            recordList[1].quarter + " has less volume as compare with " + recordList[0].quarter + "\n\n" + recordList[0].quarter + " - " + recordList[0].volumeOfMobileData + "\n" + recordList[1].quarter + " - " + recordList[1].volumeOfMobileData
        Assert.assertEquals(quarter2, Utils.getDecreasedVolumeDetail(recordList))
    }

    @Test
    fun getDecreasedVolumeQuarter3() {

        val recordList: MutableList<Record> = mutableListOf()
        recordList.add(Record(1, "2009-Q1", "0.2212e23"))
        recordList.add(Record(2, "2009-Q2", "0.4412e23"))
        recordList.add(Record(3, "2009-Q3", "0.312e23"))
        recordList.add(Record(4, "2009-Q4", "0.5112e23"))

        val quarter3 =
            recordList[2].quarter + " has less volume as compare with " + recordList[1].quarter + "\n\n" + recordList[1].quarter + " - " + recordList[1].volumeOfMobileData + "\n" + recordList[2].quarter + " - " + recordList[2].volumeOfMobileData
        Assert.assertEquals(quarter3, Utils.getDecreasedVolumeDetail(recordList))
    }

    @Test
    fun getDecreasedVolumeQuarter4() {

        val recordList: MutableList<Record> = mutableListOf()
        recordList.add(Record(1, "2009-Q1", "0.2212e23"))
        recordList.add(Record(2, "2009-Q2", "0.2412e23"))
        recordList.add(Record(3, "2009-Q3", "0.512e23"))
        recordList.add(Record(4, "2009-Q4", "0.4112e23"))

        val quarter4 =
            recordList[3].quarter + " has less volume as compare with " + recordList[2].quarter + "\n\n" + recordList[2].quarter + " - " + recordList[2].volumeOfMobileData + "\n" + recordList[3].quarter + " - " + recordList[3].volumeOfMobileData
        Assert.assertEquals(quarter4, Utils.getDecreasedVolumeDetail(recordList))

    }

}