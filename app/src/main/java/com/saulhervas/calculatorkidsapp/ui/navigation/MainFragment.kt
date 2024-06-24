package com.saulhervas.calculatorkidsapp.ui.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.saulhervas.calculatorkidsapp.R
import com.saulhervas.calculatorkidsapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.btnAddition.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_additionFragment)
        }

        binding.btnSubtraction.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_subtractionFragment)
        }

        return binding.root


    }



}