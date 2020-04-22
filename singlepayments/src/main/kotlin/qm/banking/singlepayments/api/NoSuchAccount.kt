package qm.banking.singlepayments.api

class NoSuchAccount(account: InternalAccount) : RuntimeException("Account not found $account")