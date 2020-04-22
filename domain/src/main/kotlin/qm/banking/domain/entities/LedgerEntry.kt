package qm.banking.domain.entities

class LedgerEntry(val amount: Int, val from: IBAN, val to: IBAN) {

    override fun toString(): String {
        return "LedgerEntry{" +
                "amount=" + amount +
                ", from=" + from +
                ", to=" + to +
                '}'
    }

}