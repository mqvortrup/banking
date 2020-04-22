package qm.banking.domain.entities

class InsufficientFundsException(iban: IBAN) : RuntimeException("Insufficient funds in $iban")