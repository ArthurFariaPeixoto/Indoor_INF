// src/main/kotlin/com/seu_pacote_do_projeto/MainActivity.kt
import android.content.Intent
import android.nfc.NdefMessage
import android.nfc.NdefRecord
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val nodes = listOf(
        Node(1, 100F, 100F),
        Node(2, 200F, 200F),
        Node(3, 300F, 300F),
        // Adicione mais nós conforme necessário
    )

    private val connections = listOf(
        Connection(nodes[0], nodes[1], calculateDistance(nodes[0], nodes[1])),
        Connection(nodes[1], nodes[2], calculateDistance(nodes[1], nodes[2])),
        // Adicione mais conexões conforme necessário
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapImageView: ImageView = findViewById(R.id.mapImageView)
        mapImageView.setOnClickListener { view -> onMapClick(view) }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleNfcIntent(intent)
    }

    private fun onMapClick(view: View) {
        // Simulação de leitura de NFC ao clicar no mapa
        val nodeId = "2" // Simulando um ID lido da tag NFC

        // Agora você pode usar o nodeId para identificar o nó no grafo
        // e tomar as ações necessárias, como mostrar no mapa
        showNodeOnMap(nodeId)
    }

    private fun showNodeOnMap(nodeId: String) {
        val pathfinding = Pathfinding(nodes, connections)
        try {
            val path = pathfinding.findPath(1, nodeId.toInt())

            // Exibir trajeto no mapa (implementação pendente)
            // Aqui você precisará de uma lógica para desenhar o trajeto no mapa
            Toast.makeText(this, "Estou no ponto $nodeId", Toast.LENGTH_SHORT).show()

        } catch (e: IllegalArgumentException) {
            Toast.makeText(this, "Node não encontrado: $nodeId", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleNfcIntent(intent: Intent?) {
        if (intent?.action == NfcAdapter.ACTION_NDEF_DISCOVERED) {
            val rawMessages = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)
            val messages = rawMessages?.map { it as NdefMessage }

            messages?.forEach { message ->
                val records = message.records
                records.forEach { record ->
                    val payload = record.payload
                    val nodeId = String(payload)

                    // Simulação de leitura NFC ao tocar na tag
                    showNodeOnMap(nodeId)
                }
            }
        }
    }

    private fun calculateDistance(node1: Node, node2: Node): Float {
        return kotlin.math.sqrt((node2.x - node1.x).pow(2) + (node2.y - node1.y).pow(2))
    }
}
