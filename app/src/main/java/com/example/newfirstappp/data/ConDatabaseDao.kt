package com.example.newfirstappp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConDatabaseDao {
    @Insert
    fun insert(contact: ContactData)

    @Query("select * from table_contact")
    fun getAll(): LiveData<List<ContactData>>
}