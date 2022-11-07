package com.kaelynhughes.assignment4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaelynhughes.assignment4.databinding.FragmentResearchBinding
import com.kaelynhughes.assignment4.databinding.ResearchListItemBinding

data class ResearchArea(
    val name: String,
    val description: String,
    val faculty: String
)

class ResearchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentResearchBinding.inflate(inflater, container, false)

        val research = (0 until 100).map {
            ResearchArea("Area ${it}", "doing ${it}", "Person ${it}")
        }.toList()

        binding.researchRecyclerView.adapter = ResearchAdapter(research)
        binding.researchRecyclerView.layoutManager = LinearLayoutManager(this.context)

        return binding.root
    }
}


class ResearchAdapter(val research: List<ResearchArea>): RecyclerView.Adapter<ResearchAdapter.ResearchViewHolder>() {

    class ResearchViewHolder(val binding: ResearchListItemBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun getItemCount(): Int {
        return research.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResearchViewHolder {
        val binding = ResearchListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResearchViewHolder, position: Int) {
        val researchArea = research[position]
        holder.binding.researchAreaTextView.text = researchArea.name
        holder.binding.descriptionTextView.text = researchArea.description
        holder.binding.facultyTextView.text = researchArea.faculty
    }
}