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
        TODO()
    }

    @Test
    fun debit() {
        TODO()
    }
}