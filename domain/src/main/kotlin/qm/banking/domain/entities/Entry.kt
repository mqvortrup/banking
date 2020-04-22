package qm.banking.domain.entities

import java.time.LocalDate

sealed class Entry(open val date: LocalDate, open val message: String)
data class Debit(val amount: Int, override val date: LocalDate, override val message: String): Entry(date, message)
data class Credit(val amount: Int, override val date: LocalDate, override val message: String): Entry(date, message)
data class Balance(val amount: Int, override val date: LocalDate, override val message: String): Entry(date, message)