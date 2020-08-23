package com.example.newfirstappp.contact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.newfirstappp.data.ConDatabaseDao

class ConViewModel(val database: ConDatabaseDao,  application: Application) :
    AndroidViewModel(application){
}