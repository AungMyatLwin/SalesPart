package com.rig.salespart.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SalesDao {
    @Query("Select * from Map")
    fun getMap():List<String>

    @Query("Insert into Map (name) VALUES (:name)")
    fun insertMap(name:String)
}