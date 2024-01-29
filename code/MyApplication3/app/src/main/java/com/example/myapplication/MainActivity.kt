package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

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
                if (isUserAuthenticated()) {
                    // Defina os nós inicial e final
                    graphView.setStartNode(startNode - 1)  // Subtrai 1 para corresponder ao índice do array
                    graphView.setEndNode(endNode - 1)      // Subtrai 1 para corresponder ao índice do array

                    // Calcular o caminho mais curto
                    graphView.calculateShortestPath()

                    // Limpar texto da distância
                    textViewDistance.text = ""
                } else {
                    // Tratar usuário não autenticado
                    textViewDistance.text = "Você precisa estar autenticado para acessar o grafo."
                }
            } else {
                // Tratar entrada inválida
                textViewDistance.text = "Entrada inválida. Insira valores entre 1 e 10."
            }
        }
    }

    private fun isUserAuthenticated(): Boolean {
        // Verificar se o usuário está autenticado usando FirebaseAuth
        val currentUser = FirebaseAuth.getInstance().currentUser
        return currentUser != null
    }
}
