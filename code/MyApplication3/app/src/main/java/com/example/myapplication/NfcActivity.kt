import android.app.Activity
import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import com.example.myapplication.MyGraphView
import com.example.myapplication.R

class NfcActivity : Activity() {

    private var nfcAdapter: NfcAdapter? = null
    private lateinit var graphView: MyGraphView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa o NfcAdapter
        nfcAdapter = NfcAdapter.getDefaultAdapter(this)

        // Verifica se o dispositivo suporta NFC
        if (nfcAdapter == null) {
            Toast.makeText(this, "Este dispositivo não suporta NFC", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Verifica se o NFC está ativado
        if (!nfcAdapter!!.isEnabled) {
            Toast.makeText(this, "Ative o NFC nas configurações do dispositivo", Toast.LENGTH_SHORT).show()
        }
        if(true){
            Toast.makeText(this, "Entrou", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onResume() {
        super.onResume()

        // Configura a leitura NFC
        val nfcIntent = Intent(this, javaClass).apply {
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        }

        val pendingIntent = PendingIntent.getActivity(this, 0, nfcIntent, 0)
        val filters = arrayOf(IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED))
        val techLists = arrayOf<Array<String>>()

        nfcAdapter?.enableForegroundDispatch(this, pendingIntent, filters, techLists)
    }

    override fun onPause() {
        super.onPause()

        // Desabilita a leitura NFC quando a atividade está em segundo plano
        nfcAdapter?.disableForegroundDispatch(this)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        // Manipula a tag NFC recém-detectada
        if (NfcAdapter.ACTION_NDEF_DISCOVERED == intent.action) {
            val messages = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)
            if (messages != null) {
                processNdefMessages(messages)
            }
        }
    }

    private fun processNdefMessages(ndefMessages: Array<Parcelable>) {
        for (ndefMessage in ndefMessages) {

            val records = (ndefMessage as NdefMessage).records
            for (record in records) {
                val payload = String(record.payload)
                Toast.makeText(this, "Conteúdo da tag NFC: $payload", Toast.LENGTH_SHORT).show()

                // Chama a função para atualizar o nó de saída no MyGraphView
                graphView.updateStartNodeFromNFC(ndefMessage)
            }
        }
    }
}
