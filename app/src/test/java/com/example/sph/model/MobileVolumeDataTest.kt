package com.example.sph.model

import com.example.sph.database.Record
import org.junit.Assert.*
import org.junit.Test

class MobileVolumeDataTest {

    @Test
    fun testMobileVolumeData() {

        val recordList: List<Record> = listOf(Record(2, "2009-Q2", "0.3412e23"))
        val result = Result(recordList)
        val data = MobileVolumeData(result, true)

        assertEquals(data.success, true)
        assertEquals(data.result.records[0].id, 2)
        assertEquals(data.result.records[0].quarter, "2009-Q2")
        assertEquals(data.result.records[0].volumeOfMobileData, "0.3412e23")

    }
}