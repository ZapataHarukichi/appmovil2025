package com.example.appmovil2025.network

interface Callback<T> {
    fun onSuccess(result: T?)

    fun onFailed(exception: Exception)
}