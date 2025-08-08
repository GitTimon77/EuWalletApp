package eu.eudi.wallet.app.feature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.eudi.wallet.core.presentation.PresentationRequest
import eu.eudi.wallet.core.presentation.PresentationResult
import eu.eudi.wallet.core.WalletCore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PresentationViewModel(private val core: WalletCore): ViewModel() {
    val result = MutableStateFlow<PresentationResult?>(null)

    fun handleOpenId4Vp(requestUri: String) {
        viewModelScope.launch {
            val req = PresentationRequest.fromRequestUri(requestUri)
            result.value = core.presentCredential(req)
        }
    }
}
