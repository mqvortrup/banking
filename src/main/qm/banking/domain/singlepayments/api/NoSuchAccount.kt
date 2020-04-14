package qm.banking.domain.singlepayments.api

class NoSuchAccount(account: InternalAccount) : RuntimeException("Account not found $account")