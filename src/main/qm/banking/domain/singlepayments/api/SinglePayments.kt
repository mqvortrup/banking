package qm.banking.domain.singlepayments.api

interface SinglePayments {
    fun internalTransfer(from: InternalAccount, to: InternalAccount, amount: Int)
    fun externalTransfer(from: InternalAccount, to: ExternalAccount, amount: Int)
    fun currentBalance(account: InternalAccount): Balance
}