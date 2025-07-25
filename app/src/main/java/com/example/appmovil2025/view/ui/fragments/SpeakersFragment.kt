package com.example.appmovil2025.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmovil2025.R
import com.example.appmovil2025.model.Ponente
import com.example.appmovil2025.view.adapter.PonenteAdapter
import com.example.appmovil2025.view.adapter.SpeakerListener
import com.example.appmovil2025.viewmodel.PonentesViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [SpeakersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpeakersFragment : Fragment(R.layout.fragment_speakers), SpeakerListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PonenteAdapter
    private lateinit var viewModel: PonentesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.RVSpeakers)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        adapter = PonenteAdapter(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(PonentesViewModel::class.java)
        viewModel.refresh()

        val progressBar = view.findViewById<ProgressBar>(R.id.progressBarSpeaker)

        viewModel.isloading.observe(viewLifecycleOwner) { loading ->
            progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        }

        viewModel.listadoPonentes.observe(viewLifecycleOwner){ speakers ->
            adapter.updateData(speakers)

        }
    }

    override fun onPonenteClicked(speaker: Ponente, position: Int){
        Toast.makeText(requireContext(), "Clic en ${speaker.nombre}", Toast.LENGTH_SHORT).show()
    }
}