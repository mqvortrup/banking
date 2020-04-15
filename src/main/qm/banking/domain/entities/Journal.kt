package qm.banking.domain.entities

import java.time.LocalDate

class Journal {

    private var _entries : MutableList<Entry> = mutableListOf(Balance(0, LocalDate.now(), "Initial balance"))
    val entries : List<Entry>
        get() = _entries as List<Entry>

    var currentBalance : Balance = entries[0] as Balance
        private set

    fun credit(amount: Int, message: String): Unit {
        val now = LocalDate.now()
        _entries.add(Credit(amount, now, message));
        currentBalance = Balance(currentBalance.amount + amount, now, "momentary balance")
    }

    fun debit(amount: Int, message: String): Unit {
        val now = LocalDate.now()
        _entries.add(Debit(amount, now, message));
        currentBalance = Balance(currentBalance.amount - amount, now, "momentary balance")
    }
}