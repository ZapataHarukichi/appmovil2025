package com.example.appmovil2025.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmovil2025.ui.model.ScheduleItem
import com.example.appmovil2025.databinding.FragmentScheduleBinding
import com.example.appmovil2025.R
import com.example.appmovil2025.ui.adapters.ScheduleAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/*private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"*/

/**
 * A simple [Fragment] subclass.
 * Use the [ScheduleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScheduleFragment : Fragment() {
    private var _binding: FragmentScheduleBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter : ScheduleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scheduleList = listOf(
            ScheduleItem("9:00 A.M.", "Título conferencia", "Nombre expositor", "Design"),
            ScheduleItem("11:00 A.M.", "Título conferencia", "Nombre expositor", "Design"),
            ScheduleItem("14:00 A.M.", "Título conferencia", "Nombre expositor", "Design"),
            ScheduleItem("16:00 A.M.", "Título conferencia", "Nombre expositor", "Design")
            )

        adapter = ScheduleAdapter(scheduleList)
        binding.RVSchedule.layoutManager = LinearLayoutManager(requireContext())
        binding.RVSchedule.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ScheduleFragment.
         */
        // TODO: Rename and change types and number of parameters
    }
}