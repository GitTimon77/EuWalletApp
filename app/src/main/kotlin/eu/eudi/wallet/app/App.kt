package eu.eudi.wallet.app

import android.app.Application
import eu.eudi.wallet.core.WalletCore
import eu.eudi.wallet.doc.DocumentManager
import eu.eudi.wallet.rqes.RqesClient

class App : Application() {

    lateinit var walletCore: WalletCore
        private set

    lateinit var documentManager: DocumentManager
        private set

    lateinit var rqesClient: RqesClient
        private set

    override fun onCreate() {
        super.onCreate()
        // Init aus den Libraries (je nach tatsächlichem API der Module):
        walletCore = WalletCore.init(context = this)
        documentManager = DocumentManager.default(this)
        rqesClient = RqesClient.create(this)
    }
}
