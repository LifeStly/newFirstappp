package com.example.newfirstappp.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class Database : RoomDatabase(){

    abstract val databaseDao: DatabaseDao
    companion object{
        private var INSTANCE: Database? = null

        fun  getInstance(context: Context): Database{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        Database::class.java,
                        "contact_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}