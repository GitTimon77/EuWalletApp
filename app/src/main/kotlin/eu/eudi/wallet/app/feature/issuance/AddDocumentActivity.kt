package eu.eudi.wallet.app.feature.issuance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import eu.eudi.wallet.app.App
import kotlinx.coroutines.launch

class AddDocumentActivity : ComponentActivity() {

    private val vm by viewModels<IssuanceViewModel> {
        val app = application as App
        IssuanceViewModelFactory(app.walletCore)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Beispiel: QR-Code scannt "offerUrl"
        val offerUrl = intent.getStringExtra("offerUrl") ?: return

        lifecycleScope.launch {
            vm.startIssuance(offerUrl)
        }
    }
}
