package qm.banking.domain.entities

import qm.banking.domain.singlepayments.api.InternalAccount

class LedgerEntry(val amount: Int, val from: InternalAccount, val to: InternalAccount) {

    override fun toString(): String {
        return "LedgerEntry{" +
                "amount=" + amount +
                ", from=" + from +
                ", to=" + to +
                '}'
    }

}