package qm.banking.singlepayments.api

import qm.banking.domain.entities.IBAN

class InternalAccount(val iban: IBAN) {
    override fun toString() : String = "IBAN: $iban"
}