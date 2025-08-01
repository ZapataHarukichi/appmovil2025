package com.example.appmovil2025.view.ui.fragments

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.appmovil2025.R
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.example.appmovil2025.databinding.FragmentScheduleDetailDialogBinding
import com.example.appmovil2025.model.Conferencia
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.Locale


class ScheduleDetailDialogFragment : DialogFragment() {
    private var _binding: FragmentScheduleDetailDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setStyle(STYLE_NORMAL, R.style.FullScreenDetailStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScheduleDetailDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val conferencia = arguments?.getSerializable("conferencia") as? Conferencia ?: return

        val toolbar: Toolbar = view.findViewById(R.id.TBscheduledetaildialog)
        toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbar.setNavigationOnClickListener { dismiss() }

        // Formatear la fecha
        val pattern = "dd/MM/yyyy hh:mm a"
        val simpleDF = SimpleDateFormat(pattern, Locale.getDefault())
        val date = simpleDF.format(conferencia.horafecha)

        // Asignar valores al layout
        binding.TVItemScheduleHoraDetailDialog.text = date
        binding.TVscheduledetaildialog.text = conferencia.titulo
        binding.TVItemScheduleDescripcionDetailDialog.text = conferencia.descripcion
        binding.TVItemScheduleExpositorDetailDialog.text = conferencia.expositor
        binding.TVItemScheduleBotonDetailDialog.text = conferencia.topico
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
