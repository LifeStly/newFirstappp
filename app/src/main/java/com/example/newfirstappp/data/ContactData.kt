package com.example.newfirstappp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Table_contact")
data class ContactData (
    @PrimaryKey(autoGenerate = true)
    var contactId: Long = 0L,
    @ColumnInfo(name = "name")
    var name: String = "unnamed",
    @ColumnInfo(name = "phone")
    var phone: String = ""
)