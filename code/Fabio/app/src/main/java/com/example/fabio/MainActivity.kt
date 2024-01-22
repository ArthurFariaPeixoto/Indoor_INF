// src/main/java/com.example.mapsimulation/MainActivity.kt
package com.example.fabio

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fabio.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapImageView: ImageView = findViewById(R.id.mapImageView)
        mapImageView.setOnClickListener { onMapClick(it) }
    }

    fun onMapClick(view: View) {
        // Lógica para lidar com o clique no mapa
        val toastMessage = "Clique no mapa! Adicione lógica de trajeto aqui."
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        // Adicione a lógica de simulação de localização e trajetos aqui
    }
}
