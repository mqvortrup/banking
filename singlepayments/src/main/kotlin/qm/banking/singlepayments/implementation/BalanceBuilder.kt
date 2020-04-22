package qm.banking.singlepayments.implementation

import qm.banking.domain.entities.Account
import qm.banking.singlepayments.api.Balance
import java.time.LocalDateTime

object BalanceBuilder {
    fun balance(account: Account): Balance {
        return Balance(account.iban, LocalDateTime.now(), account.balance)
    }
}