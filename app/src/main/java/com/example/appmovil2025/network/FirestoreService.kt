package com.example.appmovil2025.network

import com.example.appmovil2025.model.Conferencia
import com.example.appmovil2025.model.Ponente
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

const val CONFERENCIA_COLLECTION_NAME = "Conferencias"
const val PONENTE_COLLECCTION_NAME = "Ponentes"


class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firebaseFirestore.firestoreSettings = settings
    }

    fun getPonentes(callback: Callback<List<Ponente>>){
        firebaseFirestore.collection(PONENTE_COLLECCTION_NAME)
            .orderBy("categoria")
            .get()
            .addOnSuccessListener { result->
                for(doc in result){
                    val list = result.toObjects(Ponente::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getConferencias(callback: Callback<List<Conferencia>>){
        firebaseFirestore.collection(CONFERENCIA_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result){
                    val list = result.toObjects(Conferencia::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}