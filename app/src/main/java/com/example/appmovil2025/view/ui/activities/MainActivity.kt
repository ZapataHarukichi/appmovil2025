package com.example.appmovil2025.view.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.appmovil2025.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enableEdgeToEdge()
        setSupportActionBar(findViewById(R.id.toolbar_principal))
        supportActionBar?.title = "MOBILE SUMMIT 2025"
        configNav()

        }
        private fun configNav(){
            val navController = findNavController(R.id.nav_host_fragment)
            val bottomNavigationView = findViewById<BottomNavigationView>(R.id.btn_menu)
            NavigationUI.setupWithNavController(bottomNavigationView, navController)
        }

//
//        val firebaseFirestore = FirebaseFirestore.getInstance()
//        for (i in 0 until jsonArr2.length()) {
//            val aux = jsonArr2.getJSONObject(i)
//            var conferencia = Conferencia()
//            conferencia.titulo = aux.getString("title")
//            conferencia.descripcion = aux.getString("description")
//            conferencia.topico = aux.getString("tag")
//            val cal = Calendar.getInstance()
//            cal.timeInMillis = aux.getLong("datetime") * 1000
//            conferencia.horafecha = cal.time
//            conferencia.expositor =aux.getString("speaker")
//
//            firebaseFirestore.collection("Conferencias").document().set(conferencia)
//        }
}