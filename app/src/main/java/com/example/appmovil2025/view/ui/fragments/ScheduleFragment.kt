package com.example.appmovil2025.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmovil2025.databinding.FragmentScheduleBinding
import com.example.appmovil2025.R
import com.example.appmovil2025.model.Conferencia
import com.example.appmovil2025.network.Callback
import com.example.appmovil2025.network.FirestoreService
import com.example.appmovil2025.view.adapter.ConferenciaAdapter
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.appmovil2025.view.adapter.ScheduleListener
import com.example.appmovil2025.viewmodel.ConferenciasViewModel
import android.widget.ProgressBar
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import java.io.OutputStream

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/*private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"*/

/**
 * A simple [Fragment] subclass.
 * Use the [ScheduleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScheduleFragment : Fragment(), ScheduleListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ConferenciaAdapter
    private lateinit var viewModel: ConferenciasViewModel
    private lateinit var firestoreService: FirestoreService
    private lateinit var progressBar : ProgressBar

    private val listaConferencias = ArrayList<Conferencia>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.RVSchedule)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = ConferenciaAdapter(this)
//        recyclerView.apply{
//
//        }
        recyclerView.adapter = adapter
        progressBar = view.findViewById<ProgressBar>(R.id.progressBarSchedule)

        // inicializar VM
        viewModel = ViewModelProvider(this)[ConferenciasViewModel::class.java]
        observeViewModel()
        viewModel.refresh()
    }

    override fun onConferenciaClicked(conferencia: Conferencia, position: Int) {
        Toast.makeText(requireContext(), "Clic en ${conferencia.titulo}", Toast.LENGTH_SHORT).show()
        val bundle = Bundle().apply {
            putSerializable("conferencia", conferencia)
        }
        findNavController().navigate(R.id.ScheduleDetailDialogFragment, bundle)

    }
    private fun cargarConferencias(lista: List<Conferencia>){
        adapter.updateData(lista)
        adapter.notifyDataSetChanged()
    }

    fun observeViewModel(){
        viewModel.isloading.observe(viewLifecycleOwner) { loading ->
            progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        }

        viewModel.listadoConferencias.observe(viewLifecycleOwner){ conferencias ->
            adapter.updateData(conferencias)
            viewModel.isloading.observe(viewLifecycleOwner) {loading ->  }
        }
    }


}