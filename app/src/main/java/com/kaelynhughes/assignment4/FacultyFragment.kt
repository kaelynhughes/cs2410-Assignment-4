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
    val title: String,
    val office: String
)

class FacultyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFacultyBinding.inflate(inflater, container, false)

        val faculty = listOf(
            FacultyMember("Mahdi Nasrullah Al-Ameen", "Assistant Professor", "Old Main 401F"),
            FacultyMember("Vicki Allan", "Associate Professor", "Old Main 429"),
            FacultyMember("Soukaina Filali Boubrahimi", "Assistant Professor", "Old Main 401A"),
            FacultyMember("Heng-Da Cheng", "Professor", "Old Main 401B"),
            FacultyMember("Isaac Cho", "Assistant Professor", "Old Main 402G"),
            FacultyMember("Stephen Clyde", "Emeritus Associate Professor", "Old Main 418"),
            FacultyMember("Joseph Ditton", "Professional Practice Assistant Professor", "Old Main 420"),
            FacultyMember("Curtis Dyreson", "Professor", "Old Main 402A"),
            FacultyMember("John Edwards", "Assistant Professor", "Old Main 401D"),
            FacultyMember("Erik Falor", "Professional Practice Associate Professor", "Old Main 418A"),
            FacultyMember("Nicholas Flann", "Associate Professor", "Old Main 402C"),
            FacultyMember("Mario Harper", "Assistant Professor", "Old Main 401E"),
            FacultyMember("Hamid Karimi", "Assistant Professor", "Old Main 418"),
            FacultyMember("Rakesh Kaundal", "Assistant Professor", "CIB 101B"),
            FacultyMember("Vladimir Kulyukin", "Associate Professor", "Old Main 402D"),
            FacultyMember("Chad Mano", "Professional Practice Associate Professor", "Old Main 435"),
            FacultyMember("Dean Mathias", "Professional Practice Associate Professor", "Old Main 426"),
            FacultyMember("Shah Muhammad Hamdi", "Assistant Professor", "Old Main 437"),
            FacultyMember("Steve Petruzza", "Assistant Professor", "Old Main 424"),
            FacultyMember("Xiaojun Qi", "Department Head and Professor", "Old Main 414A"),
            FacultyMember("Haitao Wang", "Professor", "Old Main 402F"),
            FacultyMember("Dan Watson", "Associate Professor", "Old Main 402B"),
            FacultyMember("Shuhan Yuan", "Assistant Professor", "Old Main 401C")
        )


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
        holder.binding.emailTextView.text = facultyMember.title
        holder.binding.officeTextView.text = facultyMember.office
    }
}