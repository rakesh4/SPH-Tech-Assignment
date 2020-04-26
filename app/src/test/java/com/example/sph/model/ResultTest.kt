package com.example.sph.model

import com.example.sph.database.Record
import org.junit.Assert.*
import org.junit.Test

class ResultTest {

    @Test
    fun testResultValue() {
        val recordList: List<Record> = listOf(Record(2, "2009-Q2", "0.3412e23"))

        assertEquals(recordList[0].id, 2)
        assertEquals(recordList[0].quarter, "2009-Q2")
        assertEquals(recordList[0].volumeOfMobileData, "0.3412e23")
    }

    @Test
    fun testResultEmptyValue() {
        val recordList: List<Record> = emptyList()
        assertEquals(0, recordList.size)
    }

}