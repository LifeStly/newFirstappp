package com.example.newfirstappp.contact

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.newfirstappp.R
import com.example.newfirstappp.data.ConDatabase
import com.example.newfirstappp.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        val binding = DataBindingUtil.inflate<FragmentContactBinding>(
            inflater,
            R.layout.fragment_contact,
            container,
            false)
        setHasOptionsMenu(true)
        val  application = requireNotNull(this.activity).application

        val dataSource = ConDatabase.getInstance(application).conDatabaseDao

        val viewModelFactory = ConViewModelFactory(dataSource,binding,application)

        val  conViewModel = ViewModelProvider(this,viewModelFactory).get(ConViewModel::class.java)

        binding.conViewModel = conViewModel
        binding.lifecycleOwner = this
        binding.conViewModel = conViewModel

        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()
        ) || super.onOptionsItemSelected(item)
    }
}