package com.example.appmovil2025.view.ui.fragments

import android.content.ActivityNotFoundException
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.appmovil2025.R
import com.example.appmovil2025.databinding.FragmentSpeakersDetailDialogBinding
import com.example.appmovil2025.model.Ponente
import android.content.Intent
import android.net.Uri
import android.widget.Toast

class SpeakersDetailDialogFragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setStyle(STYLE_NORMAL, R.style.FullScreenDetailStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speakers_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val ponente = arguments?.getSerializable("ponente") as? Ponente ?:return

        val toolbar: Toolbar = view.findViewById(R.id.ToolbarSpeakerDetailDialog)
        toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbar.setNavigationOnClickListener{dismiss()}

        val imagePonente = view.findViewById<ImageView>(R.id.speakerDetailImage)
        val namePonente = view.findViewById<TextView>(R.id.speakerDetailName)
        val jobPonente = view.findViewById<TextView>(R.id.speakerDetailJobTitle)
        val companyPonente = view.findViewById<TextView>(R.id.speakerDetailCompany)
        val twitterPonente = view.findViewById<ImageView>(R.id.speakerDetailTwitter)
        val descripcionPonente = view.findViewById<TextView>(R.id.speakerDetailDescription)

        Glide.with(requireContext())
            .load(ponente.imagen)
            .placeholder(R.drawable.logo_user)
            .into(imagePonente)

        namePonente.text = ponente.nombre

        jobPonente.text = ponente.trabajo
        companyPonente.text = ponente.profesion
        twitterPonente.setOnClickListener {
            ponente.twitter.takeIf { it.isNotBlank()}?.let{ username ->
                val url = if(username.startsWith("http")){
                    username
                } else{
                    "https://x.com/${username.removePrefix("@")}"
                }
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                val chooser = Intent.createChooser(intent, "Abrir con...")

                try {
                    startActivity(chooser)
                } catch (e: ActivityNotFoundException){
                    Toast.makeText(requireContext(), "No se pudo abrir el enlace", Toast.LENGTH_SHORT).show()
                }
            }
        }
        descripcionPonente.text = ponente.biografia


    }

    override fun onStart(){
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}