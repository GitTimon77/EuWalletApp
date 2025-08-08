package eu.eudi.wallet.app.feature.rqes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import eu.eudi.wallet.app.App
import eu.eudi.wallet.app.databinding.ScreenRqesBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.security.MessageDigest

class RqesActivity : ComponentActivity() {

    private lateinit var binding: ScreenRqesBinding

    private val vm by viewModels<RqesViewModel> {
        val app = application as App
        RqesViewModelFactory(app.rqesClient)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ScreenRqesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSign.setOnClickListener {
            // Demo: wir hashen statisch einen Payload
            val payload = "Hello EUDI".toByteArray()
            val md = MessageDigest.getInstance("SHA-256")
            vm.sign(md.digest(payload))
        }

        lifecycleScope.launch {
            vm.state.collectLatest { state ->
                when (state) {
                    is RqesState.Idle -> binding.txtStatus.text = "Bereit"
                    is RqesState.InProgress -> binding.txtStatus.text = "Signiere..."
                    is RqesState.Success -> binding.txtStatus.text = "Signatur erhalten (${state.signature.size} Bytes)"
                    is RqesState.Error -> binding.txtStatus.text = "Fehler: ${state.message}"
                }
            }
        }
    }
}
