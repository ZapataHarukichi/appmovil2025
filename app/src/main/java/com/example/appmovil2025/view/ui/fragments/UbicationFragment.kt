package com.example.appmovil2025.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.appmovil2025.R
import com.example.appmovil2025.model.Ubicacion
import com.example.appmovil2025.viewmodel.UbicacionViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.SupportMapFragment

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UbicationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UbicationFragment : Fragment(), OnMapReadyCallback {
//    private lateinit var viewModel: UbicacionViewModel
    private lateinit var mMap: GoogleMap


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ubication, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)



    }

    override fun onMapReady(googleMap: GoogleMap){
        val ubicacion = Ubicacion()
        mMap = googleMap

        val ubicacionExacta = LatLng(ubicacion.latitude.toDouble(), ubicacion.longitude.toDouble())
        val marker = mMap.addMarker(MarkerOptions().position(ubicacionExacta).title("Centro Cultural UNS"))
        val zoom = 16f
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ubicacionExacta, zoom))
        mMap.setOnMarkerClickListener { clickedMarker ->
            if(clickedMarker == marker){
                findNavController().navigate(R.id.action_navMapFragment_to_UbicationDetailDialogFragment)
                true
            } else{
                false
            }
        }

    }
}