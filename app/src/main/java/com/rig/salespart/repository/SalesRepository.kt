package com.rig.salespart.repository

import com.rig.salespart.room.SalesDao

class SalesRepository(private val dao: SalesDao) {
    fun getMap(): List<String>? {
        return dao?.getMap()
    }

    fun insertMap(name:String): Unit? {
        return dao?.insertMap(name)
    }
}