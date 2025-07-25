package com.example.appmovil2025.viewmodel
import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appmovil2025.model.Ponente
import com.example.appmovil2025.network.Callback
import com.example.appmovil2025.network.FirestoreService

import kotlin.collections.List

class PonentesViewModel : ViewModel(){
    val firestoreService = FirestoreService()
    var listadoPonentes: MutableLiveData<List<Ponente>> = MutableLiveData()
    var isloading = MutableLiveData<Boolean>()

    fun refresh(){
        isloading.value = true
        getPonentesFromFirebase()
    }


    private fun getPonentesFromFirebase(){
        firestoreService.getPonentes(object: Callback<List<Ponente>> {
            @SuppressLint("NullSafeMutableLiveData")
            override fun onSuccess(result: List<Ponente>) {
                listadoPonentes.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }


        })

    }

    private fun processFinished(){
        isloading.value = false
    }
}