package eu.eudi.wallet.app.feature.issuance

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.eudi.wallet.core.WalletCore
import eu.eudi.wallet.core.issuance.IssuanceRequest
import eu.eudi.wallet.core.issuance.IssuanceResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class IssuanceViewModel(
    private val core: WalletCore
) : ViewModel() {

    private val _state = MutableStateFlow<IssuanceResult?>(null)
    val state: StateFlow<IssuanceResult?> = _state

    fun startIssuance(offerUrl: String) {
        viewModelScope.launch {
            val req = IssuanceRequest.fromOfferUrl(offerUrl)
            val result = core.issueCredential(req)
            _state.value = result
        }
    }
}
