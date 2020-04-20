package qm.banking.domain.singlepayments.implementation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import qm.banking.domain.entities.*
import qm.banking.domain.singlepayments.api.*
import java.util.*

internal class SinglePaymentsImplementationTest {
    private lateinit var singlePayments: SinglePayments
    private lateinit var accountAccess: AccountAccess

    @BeforeEach
    fun setup() {
        accountAccess = MockAccountAccess()
        singlePayments = SinglePaymentsImplementation(accountAccess)
    }

    @Test
    private fun internalTransferSufficientFunds() {
        val from = InternalAccount(IBAN_from)
        val to = InternalAccount(IBAN_to)
        singlePayments.internalTransfer(from, to, 500)
        Assertions.assertEquals(500, singlePayments.currentBalance(InternalAccount(IBAN_from)).amount)
        Assertions.assertEquals(500, singlePayments.currentBalance(InternalAccount(IBAN_to)).amount)
        println("bla bla")
    }

    @Test
    private fun internalTransferInsufficientFunds() {
        val from = InternalAccount(IBAN_to)
        val to = InternalAccount(IBAN_from)
        Assertions.assertThrows(InsufficientFundsException::class.java) { singlePayments.internalTransfer(from, to, 500) }
    }

    @Test
    private fun externalTransferSufficientFunds() {
        val from = InternalAccount(IBAN_from)
        val to = ExternalAccount(IBAN_to_E)
        singlePayments.externalTransfer(from, to, 500)
        Assertions.assertEquals(500, singlePayments.currentBalance(InternalAccount(IBAN_from)).amount)
    }

    @Test
    private fun unknownAccount() {
        Assertions.assertThrows(NoSuchAccount::class.java) { singlePayments.currentBalance(InternalAccount(IBAN("CH-no-such-acc")))}
    }

    @Test
    private fun currentBalance() {
        Assertions.assertEquals( BALANCE, singlePayments.currentBalance(InternalAccount(IBAN_from)).amount
        )
    }

    internal inner class MockAccountAccess : AccountAccess {
        var accounts: MutableMap<IBAN, Account> = HashMap()
        var journals: MutableMap<IBAN, Journal> = HashMap()
        var ledger = Ledger()
        override fun retrieveAccount(account: InternalAccount): Account {
            return accounts[account.iban] ?: throw NoSuchAccount(account)
        }

        override fun retrieveLedger(): Ledger {
            return ledger
        }

        override fun retrieveJournal(account: InternalAccount): Journal {
            return journals[account.iban] ?: throw NoSuchAccount(account)
        }

        init {
            accounts[IBAN_from] = SavingsAccount(IBAN_from).credit(BALANCE)
            accounts[IBAN_to] = SavingsAccount(IBAN_from)
        }
    }

    companion object {
        const val BALANCE = 1000
        val IBAN_from = IBAN("CH-102030")
        val IBAN_to = IBAN("CH-102035")
        val IBAN_to_E = IBAN("CH-202035")
    }
}