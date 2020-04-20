package qm.banking.domain.singlepayments.api

import qm.banking.domain.entities.Account
import qm.banking.domain.entities.Journal
import qm.banking.domain.entities.Ledger

interface AccountAccess {
    fun retrieveAccount(account: InternalAccount): Account
    fun retrieveLedger(): Ledger
    fun retrieveJournal(account: InternalAccount): Journal
}