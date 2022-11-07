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

        val research = listOf(
            ResearchArea("Artificial Intelligence",
                "Multi-agent systems, physics informed deep learning, criticality in natural systems, " +
                        "automatic differentiation, deep neural networks, AI for social impact, robotics, " +
                        "decision science, precision apiculture, precision agriculture, assistive technology, " +
                        "PIV/PTV, and computability.",
                "Faculty: Vicki Allan, Nick Flann, Hamid Karimi, Mario Harper, and Vladimir Kulyukin"),
            ResearchArea("Algorithms",
                "Planning algorithms, optimization algorithms, simulation, and computational geometry.",
                "Faculty: John Edwards, Mario Harper, and Haitao Wang"),
            ResearchArea("Augmented Virtual Reality",
                "3D user interfaces, human perception and cognition in VR and AR.",
                "Faculty: Isaac Cho"),
            ResearchArea("Computer Science Education",
                "Educational data mining, keystroke analysis, and educational psychology.",
                "Faculty: John Edwards"),
            ResearchArea("Computer Vision", "Computer vision, pattern recognition, " +
                    "breast ultrasound (BUS) image processing, pavement crack detection/classification, " +
                    "uncertainty theories & new logics,  meta-learning, deep learning for medical Information processing, " +
                    "medical image segmentation, deep learning-based object detection & recognition, " +
                    "morphed face detection,  graph-based deep learning, and machine learning.",
                "Faculty: Hengda Cheng and Xiaojun Qi"),
            ResearchArea("Cybersecurity",
                "Human aspects of security, and privacy perceptions of users.",
                "Faculty: Mahdi Nasrullah Al-Ameen"),
            ResearchArea("Data Science and Data Mining",
                "Applied data mining for space weather research and pattern discovery from " +
                        "large time series data, social network analysis, graph mining, social media mining, " +
                        "educational data mining, machine learning, deep learning, representation learning " +
                        "of graphs and multivariate time series, ML cyberinfrastructure development, " +
                        "deep learning and its applications in anomaly detection, and natural language processing.",
                "Faculty: Soukaina Filali Boubrahimi, Hamid Karimi, Shah Muhammad Hamdi, and Shuhan Yuan"),
            ResearchArea("Data Visualization and Visual Analytics",
                "Decision-making and sense making, user behavior analytics, text analytics, and data analytics.",
                "Faculty: Isaac Cho"),
            ResearchArea("Database Systems",
                "Temporal databases, hierarchical databases, and biodiversity databases.",
                "Faculty: Curtis Dyreson"),
            ResearchArea("High Performance Computing and Scientific Visualization",
                "Big data analysis and visualization, distributed and parallel computing, " +
                        "topological analysis, cyberinfrastructure, cloud computing, and simulation visualization.",
                "Faculty:  John Edwards, Steve Petruzza"),
            ResearchArea("Human-Computer Interaction",
                "User behavior and challenges in technology use and corresponding workarounds, " +
                        "virtual reality, augmented reality, and 3D user interfaces.",
                "Faculty: Mahdi Nasrullah Al-Ameen, Isaac Cho"),
            ResearchArea("Information and Communication Technology for Development",
                "Usability issues and privacy concerns around digital technology use in developing countries.",
                "Faculty: Mahdi Nasrullah Al-Ameen")
        )

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