package qm.banking.domain.entities

import java.time.LocalDate

class Journal {

    val entries : MutableList<Entry> = mutableListOf(Balance(0, LocalDate.now(), "Initial balance"))
    var currentBalance : Balance = entries[0] as Balance
        private set

    fun credit(amount: Int, message: String): Unit {
        var now = LocalDate.now()
        entries.add(Credit(amount, now, message));
        currentBalance = Balance(currentBalance.amount + amount, now, "momentary balance")
    }

    fun debit(amount: Int, message: String): Unit {
        var now = LocalDate.now()
        entries.add(Debit(amount, now, message));
        currentBalance = Balance(currentBalance.amount - amount, now, "momentary balance")
    }
}