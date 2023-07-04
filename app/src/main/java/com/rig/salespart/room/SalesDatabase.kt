package com.rig.salespart.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(EntitySales::class)], version = 1)
abstract class SalesDatabase:RoomDatabase() {
    abstract fun salesDao():SalesDao
    companion object{
        @Volatile
        private var INSTANCE : SalesDatabase?=null
        fun getInstance(context: Context):SalesDatabase?{
            synchronized(this){
                var instance = INSTANCE
                if(INSTANCE == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SalesDatabase::class.java,
                        "sales_database"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}