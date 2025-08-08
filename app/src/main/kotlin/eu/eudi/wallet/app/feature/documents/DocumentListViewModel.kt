package eu.eudi.wallet.app.feature.documents

import androidx.lifecycle.ViewModel
import eu.eudi.wallet.doc.DocumentManager
import eu.eudi.wallet.doc.model.StoredDocument

class DocumentListViewModel(
    private val dm: DocumentManager
) : ViewModel() {
    fun list(): List<StoredDocument> = dm.listDocuments()
    fun remove(id: String) = dm.removeDocument(id)
}
