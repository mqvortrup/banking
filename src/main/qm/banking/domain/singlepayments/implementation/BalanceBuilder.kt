package qm.banking.domain.singlepayments.implementation

import qm.banking.domain.entities.Account
import qm.banking.domain.singlepayments.api.Balance
import java.time.LocalDateTime

object BalanceBuilder {
    fun balance(account: Account): Balance {
        return Balance(account.iBAN, LocalDateTime.now(), account.balance)
    }
}