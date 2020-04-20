package qm.banking.domain.singlepayments.api

import qm.banking.domain.entities.IBAN
import java.time.LocalDateTime

data class Balance(val iban: IBAN, val date: LocalDateTime, val amount: Int)