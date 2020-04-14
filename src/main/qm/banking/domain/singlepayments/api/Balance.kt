package qm.banking.domain.singlepayments.api

import java.time.LocalDateTime

class Balance(val IBAN: String?, val date: LocalDateTime, val amount: Int)