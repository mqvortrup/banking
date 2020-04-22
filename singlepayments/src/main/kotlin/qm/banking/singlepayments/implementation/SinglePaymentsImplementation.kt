package qm.banking.singlepayments.implementation

import qm.banking.domain.entities.LedgerEntry
import qm.banking.singlepayments.api.*

class SinglePaymentsImplementation(private val accountAccess: AccountAccess) : SinglePayments {

    override fun internalTransfer(from: InternalAccount, to: InternalAccount, amount: Int) {
        val fromAccount = accountAccess.retrieveAccount(from)
        val toAccount = accountAccess.retrieveAccount(to)
        fromAccount.debit(amount)
        toAccount.credit(amount)
        val fromJournal = accountAccess.retrieveJournal(from)
        val toJournal = accountAccess.retrieveJournal(to)
        fromJournal.debit(amount, "")
        toJournal.credit(amount, "")
        val ledger = accountAccess.retrieveLedger()
        ledger.addEntry(LedgerEntry(amount, from.iban, to.iban))
    }

    override fun externalTransfer(from: InternalAccount, to: ExternalAccount, amount: Int) {
        throw IllegalStateException("not implemented")
    }

    override fun currentBalance(account: InternalAccount): Balance {
        val actualAccount = accountAccess.retrieveAccount(account)
        return BalanceBuilder.balance(actualAccount)
    }

}