package com.example.newfirstappp.contact

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newfirstappp.data.ConDatabaseDao
import java.lang.IllegalArgumentException
import javax.sql.DataSource

class ConViewModelFactory (
    private val dataSource: ConDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory{
    override  fun <T : ViewModel?> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(ConViewModel::class.java)){
            return ConViewModel(dataSource,application) as T
        }
        throw IllegalArgumentException("Unknow view Class")
    }
}