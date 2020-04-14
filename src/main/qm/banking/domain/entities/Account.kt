package qm.banking.domain.entities

abstract class Account(val iBAN: String, var balance: Int) {

    fun credit(amount: Int) {
        if (amount > balance) throw InsufficientFundsException(iBAN)
        balance -= amount
    }

    fun debit(amount: Int) {
        balance += amount
    }

}