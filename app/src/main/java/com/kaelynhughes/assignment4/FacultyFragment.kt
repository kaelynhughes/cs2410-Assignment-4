package com.kaelynhughes.assignment4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kaelynhughes.assignment4.databinding.FragmentFacultyBinding

class FacultyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFacultyBinding.inflate(inflater, container, false)
        return binding.root
    }
}