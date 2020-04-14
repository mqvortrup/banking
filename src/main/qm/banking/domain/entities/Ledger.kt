package qm.banking.domain.entities

import java.util.*

class Ledger {
    private val entries: MutableList<LedgerEntry> = ArrayList()
    fun addEntry(entry: LedgerEntry) {
        entries.add(entry)
    }
}