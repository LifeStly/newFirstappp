package com.example.newfirstappp.contact

import android.app.Application
import android.os.Build
import android.provider.SyncStateContract.Helpers.insert
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import com.example.newfirstappp.data.ConDatabaseDao
import com.example.newfirstappp.data.ContactData
import com.example.newfirstappp.databinding.FragmentContactBinding
import kotlinx.coroutines.*
import java.lang.StringBuilder

class ConViewModel(val database: ConDatabaseDao, val binding: FragmentContactBinding , application: Application) :
    AndroidViewModel(application){
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val contacts = database.getAll()
    val contactString = Transformations.map(contacts) { contacts ->
        formatContact(contacts)
    }
    private fun formatContact(contact: List<ContactData>): Spanned {
        val sb = StringBuilder()
        sb.apply {
            //append(resources.getString(R.string.title))
            contact.forEach {
                append(it.contactId)
                append(" : ")
                append(it.name)
                append(", ")
                append(it.phone)
                append("<br>")
            }
        }
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
        } else {
            HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    fun onContactAdd() {
        uiScope.launch {
            val newContact = ContactData()
            newContact.name = binding.editTextTextPersonName.text.toString()
            newContact.phone = binding.editTextTextPersonPhone.text.toString()
            insert(newContact)
        }
    }
    private suspend fun insert(contact: ContactData) {
        withContext(Dispatchers.IO) {
            database.insert(contact)
        }
    }
}