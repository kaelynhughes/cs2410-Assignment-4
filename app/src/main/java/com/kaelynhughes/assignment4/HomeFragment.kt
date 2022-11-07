package com.kaelynhughes.assignment4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kaelynhughes.assignment4.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.toFacultyButton.setOnClickListener {
            findNavController().navigate(R.id.home_to_faculty)
        }
        binding.toResearchButton.setOnClickListener {
            findNavController().navigate(R.id.home_to_research)
        }
        return binding.root
    }

}