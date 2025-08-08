package eu.eudi.wallet.app.feature.proximity

import eu.eudi.wallet.core.proximity.MdocSession
import eu.eudi.wallet.core.proximity.MdocRequest
import eu.eudi.wallet.core.proximity.MdocResult

class ProximitySession(private val session: MdocSession) {
    suspend fun respondTo(request: MdocRequest): MdocResult = session.respond(request)
}
