package com.example.newfirstappp.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.newfirstappp.R
import com.example.newfirstappp.data.ConDatabase
import com.example.newfirstappp.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        val binding: FragmentContactBinding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_contact,container,false)
        val  application = requireNotNull(this.activity).application

        val dataSource = ConDatabase.getInstance(application).conDatabaseDao

        val viewModelFactory = ConViewModelFactory(dataSource,application)

        val  conViewModel = ViewModelProvider(this,viewModelFactory).get(ConViewModel::class.java)

        binding.setLifecycleOwner(this)
        binding.conViewModel = conViewModel

        return binding.root
    }

}