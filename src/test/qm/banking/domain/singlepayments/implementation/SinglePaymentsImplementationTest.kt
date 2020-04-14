package qm.banking.domain.singlepayments.implementation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import qm.banking.domain.entities.Account
import qm.banking.domain.entities.InsufficientFundsException
import qm.banking.domain.entities.Ledger
import qm.banking.domain.entities.SavingsAccount
import qm.banking.domain.singlepayments.api.*
import java.util.*

internal class SinglePaymentsImplementationTest {
    private var singlePayments: SinglePayments? = null
    private var accountAccess: AccountAccess? = null

    @BeforeEach
    fun setup() {
        accountAccess = MockAccountAccess()
        singlePayments = SinglePaymentsImplementation(accountAccess as MockAccountAccess)
    }

    @Test
    fun internalTransferSufficientFunds() {
        val from = InternalAccount(IBAN_from)
        val to = InternalAccount(IBAN_to)
        singlePayments!!.internalTransfer(from, to, 500)
        Assertions.assertEquals(
                500,
                singlePayments!!.currentBalance(InternalAccount(IBAN_from)).amount
        )
        Assertions.assertEquals(
                500,
                singlePayments!!.currentBalance(InternalAccount(IBAN_to)).amount
        )
    }

    @Test
    fun internalTransferInsufficientFunds() {
        val from = InternalAccount(IBAN_to)
        val to = InternalAccount(IBAN_from)
        Assertions.assertThrows(InsufficientFundsException::class.java) { singlePayments!!.internalTransfer(from, to, 500) }
    }

    @Test
    fun externalTransferSufficientFunds() {
        val from = InternalAccount(IBAN_from)
        val to = ExternalAccount(IBAN_to_E)
        singlePayments!!.externalTransfer(from, to, 500)
        Assertions.assertEquals(
                500,
                singlePayments!!.currentBalance(InternalAccount(IBAN_from)).amount
        )
        Assertions.assertEquals(
                500,
                singlePayments!!.currentBalance(InternalAccount(IBAN_to)).amount
        )
    }

    @Test
    fun unknownAccount() {
        Assertions.assertThrows(NoSuchAccount::class.java) { singlePayments!!.currentBalance(InternalAccount("CH-no-such-acc"))}
    }

    @Test
    fun currentBalance() {
        Assertions.assertEquals(
                BALANCE,
                singlePayments!!.currentBalance(InternalAccount(IBAN_from)).amount
        )
    }

    internal inner class MockAccountAccess : AccountAccess {
        var accounts: MutableMap<String, Account> = HashMap()
        var ledger = Ledger()
        override fun retrieveAccount(accountDef: InternalAccount): Account {
            return accounts[accountDef.IBAN] ?: throw NoSuchAccount(accountDef)
        }

        override fun retrieveLedger(): Ledger {
            return ledger
        }

        init {
            accounts[IBAN_from] = SavingsAccount(IBAN_from, BALANCE)
            accounts[IBAN_to] = SavingsAccount(IBAN_from, 0)
        }
    }

    companion object {
        const val BALANCE = 1000
        const val IBAN_from = "CH-102030"
        const val IBAN_to = "CH-102035"
        const val IBAN_to_E = "CH-202035"
    }
}