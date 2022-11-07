package com.kaelynhughes.assignment4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaelynhughes.assignment4.databinding.FacultyMemberListItemBinding
import com.kaelynhughes.assignment4.databinding.FragmentFacultyBinding

data class FacultyMember(
    val name: String,
    val email: String,
    val office: String
)

class FacultyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFacultyBinding.inflate(inflater, container, false)

        val faculty = (0 until 100).map {
            FacultyMember("Person ${it}", "${it}@usu.edu", "${it}")
        }.toList()

        binding.facultyRecyclerView.adapter = FacultyAdapter(faculty)
        binding.facultyRecyclerView.layoutManager = LinearLayoutManager(this.context)

        return binding.root
    }
}


class FacultyAdapter(val faculty: List<FacultyMember>): RecyclerView.Adapter<FacultyAdapter.ViewHolder>() {

    class ViewHolder(val binding: FacultyMemberListItemBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun getItemCount(): Int {
        return faculty.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FacultyMemberListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val facultyMember = faculty[position]
        holder.binding.nameTextView.text = facultyMember.name
        holder.binding.emailTextView.text = facultyMember.email
        holder.binding.officeTextView.text = facultyMember.office
    }
}