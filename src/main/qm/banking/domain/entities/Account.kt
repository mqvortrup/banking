package qm.banking.domain.entities

abstract class Account(val iban: IBAN) {

    var balance = 0
        private set

    fun debit(amount: Int): Account {
        if (amount > balance) throw InsufficientFundsException(iban)
        balance -= amount
        return this
    }

    fun credit(amount: Int): Account {
        balance += amount
        return this
    }

}