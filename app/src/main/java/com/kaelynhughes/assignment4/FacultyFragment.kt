package com.kaelynhughes.assignment4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaelynhughes.assignment4.databinding.FragmentFacultyBinding
import com.kaelynhughes.assignment4.databinding.FacultyListItemBinding

class FacultyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFacultyBinding.inflate(inflater, container, false)
        val facultyList = {
            FacultyMember("Vicki Allan", "title", "office")
            FacultyMember("Joseph Ditton", "title", "office")
            FacultyMember("Erik Falor", "title", "office")
            FacultyMember("Dean Mathias", "title", "office")
            FacultyMember("Dan Watson", "title", "office")
        }

        binding.FacultyRecycler.adapter = FacultyAdapter(facultyList)

        binding.FacultyRecycler.layoutManager = LinearLayoutManager(this.context)

        return binding.root
    }

    data class FacultyMember(
        val name: String,
        val title: String,
        val office: String
    )
}

class FacultyAdapter(private val facultyList: List<FacultyFragment.FacultyMember>, private val onClick: (FacultyFragment.FacultyMember) -> Unit = {}): RecyclerView.Adapter<FacultyAdapter.ViewHolder>() {
    class ViewHolder(val binding: FacultyListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return facultyList.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FacultyListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val facultyMember = facultyList[position]
        holder.binding.nameTextView.text = facultyMember.name
        holder.binding.titleTextView.text = facultyMember.title
        holder.binding.officeTextView.text = facultyMember.office
        holder.binding.root.setOnClickListener() {
            onClick(facultyMember)
        }
    }
}