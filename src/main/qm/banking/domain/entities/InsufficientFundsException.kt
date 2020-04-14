package qm.banking.domain.entities

class InsufficientFundsException(iBAN: String) : RuntimeException("Insufficient funds in $iBAN")