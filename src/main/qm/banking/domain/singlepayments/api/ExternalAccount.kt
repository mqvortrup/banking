package qm.banking.domain.singlepayments.api

import qm.banking.domain.entities.IBAN

class ExternalAccount(val iban: IBAN) {
    override fun toString() : String = "IBAN: $iban"
}