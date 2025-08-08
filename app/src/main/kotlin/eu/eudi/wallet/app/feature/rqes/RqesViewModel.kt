package eu.eudi.wallet.app.feature.rqes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.eudi.wallet.rqes.RqesClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed interface RqesState {
    object Idle : RqesState
    object InProgress : RqesState
    data class Success(val signature: ByteArray) : RqesState
    data class Error(val message: String) : RqesState
}

class RqesViewModel(
    private val rqes: RqesClient
) : ViewModel() {

    private val _state = MutableStateFlow<RqesState>(RqesState.Idle)
    val state: StateFlow<RqesState> = _state

    fun sign(hashToSign: ByteArray) {
        viewModelScope.launch {
            _state.value = RqesState.InProgress
            try {
                val sig = rqes.sign(hashToSign) // zeigt ggf. UI/2FA
                _state.value = RqesState.Success(sig)
            } catch (t: Throwable) {
                _state.value = RqesState.Error(t.message ?: "RQES fehlgeschlagen")
            }
        }
    }
}
