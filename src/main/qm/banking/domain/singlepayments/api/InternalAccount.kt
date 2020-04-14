package qm.banking.domain.singlepayments.api

class InternalAccount(val IBAN: String) {
    override fun toString() : String = "IBAN: $IBAN"
}