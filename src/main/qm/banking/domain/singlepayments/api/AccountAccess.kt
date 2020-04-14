package qm.banking.domain.singlepayments.api

import qm.banking.domain.entities.Account
import qm.banking.domain.entities.Ledger

interface AccountAccess {
    fun retrieveAccount(accountDef: InternalAccount): Account
    fun retrieveLedger(): Ledger
}