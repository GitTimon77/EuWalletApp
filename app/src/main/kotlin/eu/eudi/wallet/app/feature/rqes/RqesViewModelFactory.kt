package eu.eudi.wallet.app.feature.rqes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import eu.eudi.wallet.rqes.RqesClient

class RqesViewModelFactory(
    private val rqes: RqesClient
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RqesViewModel(rqes) as T
    }
}
