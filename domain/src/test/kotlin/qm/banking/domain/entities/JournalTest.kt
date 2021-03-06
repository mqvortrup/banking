package qm.banking.domain.entities

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class JournalTest {

    private lateinit var journal: Journal

    @BeforeEach
    fun setUp() {
        journal = Journal()
    }

    @Test
    fun getCurrentBalance() {
        Assertions.assertEquals(0, journal.currentBalance.amount, "Initial balance must be 0")
    }

    @Test
    fun credit() {
        journal.credit(AMOUNT, "")
        Assertions.assertEquals(AMOUNT, journal.currentBalance.amount, "Balance after credit must be $AMOUNT")
    }

    @Test
    fun debit() {
        journal.debit(AMOUNT, "")
        Assertions.assertEquals(-AMOUNT, journal.currentBalance.amount, "Balance after credit must be -$AMOUNT")
    }

    companion object {
        const val AMOUNT = 500
    }
}