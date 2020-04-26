package com.example.sph.database

import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class RecordTest {

    private lateinit var result: Record

    @Test
    fun testRecordValue()
    {
        result = Record(1, "2008-Q1","1.454544")

        assertEquals(result.id, 1)
        assertEquals(result.quarter, "2008-Q1")
        assertEquals(result.volumeOfMobileData,"1.454544" )

    }

    @Test
    fun testRecordEmptyValue(){

        result = Record(0,"","")

        assertEquals(result.id, 0)
        assertEquals(result.quarter, "")
        assertEquals(result.volumeOfMobileData,"" )
        }

}