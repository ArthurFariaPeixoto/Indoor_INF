package com.example.myapplication

import NfcActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var graphView: MyGraphView
    private lateinit var editTextStartNode: EditText
    private lateinit var editTextEndNode: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textViewDistance: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        graphView = findViewById(R.id.graphView)
        editTextStartNode = findViewById(R.id.editTextStartNode)
        editTextEndNode = findViewById(R.id.editTextEndNode)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewDistance = findViewById(R.id.textViewDistance)

        buttonCalculate.setOnClickListener {
            val startNode = editTextStartNode.text.toString().toIntOrNull()
            val endNode = editTextEndNode.text.toString().toIntOrNull()

            if (startNode != null && endNode != null) {
                // Defina os nós inicial e final
                graphView.setStartNode(startNode - 1)  // Subtrai 1 para corresponder ao índice do array
                graphView.setEndNode(endNode - 1)      // Subtrai 1 para corresponder ao índice do array

                // Calcular o caminho mais curto
                graphView.calculateShortestPath()

                // Limpar texto da distância
                textViewDistance.text = ""
            } else {
                // Tratar entrada inválida
                textViewDistance.text = "Entrada inválida."
            }
        }
    }
}








