package com.example.appmovil2025.view.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.appmovil2025.R
import com.example.appmovil2025.model.Ubicacion
import android.net.Uri
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UbicationDetailDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UbicationDetailDialogFragment : DialogFragment(){
    private val ubicacion = Ubicacion()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ubication_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar: Toolbar = view.findViewById(R.id.toolbarCentroCultural)
        toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbar.setNavigationOnClickListener{dismiss()}
        view.findViewById<TextView>(R.id.textDireccion)?.text = ubicacion.direccion
        view.findViewById<TextView>(R.id.textTelefono)?.text = ubicacion.telefono
        view.findViewById<TextView>(R.id.textEnlace)?.apply{
            text = ubicacion.web
            setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ubicacion.web))
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}