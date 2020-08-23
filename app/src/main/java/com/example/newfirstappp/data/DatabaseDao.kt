package com.example.newfirstappp.data

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DatabaseDao {
    @Insert
    fun insert(contact: contactData)

    @Query("select * from table_contact order by contactId DESC")
    fun getName(): LiveData<List<contactData>>
}