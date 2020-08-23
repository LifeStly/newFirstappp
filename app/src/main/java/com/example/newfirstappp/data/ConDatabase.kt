package com.example.newfirstappp.data

import android.content.Context
import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ContactData::class],version = 1)
abstract class ConDatabase : RoomDatabase(){

    abstract val conDatabaseDao: ConDatabaseDao
    companion object{
        private var INSTANCE: ConDatabase? = null

        fun  getInstance(context: Context): ConDatabase{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ConDatabase::class.java,
                        "contact_his_database"
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