package qm.banking.domain.singlepayments.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qm.banking.domain.entities.Account;
import qm.banking.domain.entities.InsufficientFundsException;
import qm.banking.domain.entities.Ledger;
import qm.banking.domain.entities.SavingsAccount;
import qm.banking.domain.singlepayments.api.AccountAccess;
import qm.banking.domain.singlepayments.api.ExternalAccount;
import qm.banking.domain.singlepayments.api.InternalAccount;
import qm.banking.domain.singlepayments.api.SinglePayments;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SinglePaymentsImplementationTest {

    public static final int BALANCE = 1000;
    public static final String IBAN_from = "CH-102030";
    public static final String IBAN_to = "CH-102035";
    public static final String IBAN_to_E = "CH-202035";

    private SinglePayments singlePayments;
    private AccountAccess accountAccess;

    @BeforeEach
    void setup() {
        accountAccess = new MockAccountAccess();
        singlePayments = new SinglePaymentsImplementation(accountAccess);
    }

    @Test
    void internalTransferSufficientFunds() {
        InternalAccount from = new InternalAccount(IBAN_from);
        InternalAccount to = new InternalAccount(IBAN_to);
        singlePayments.internalTransfer(from, to, 500);
        assertEquals(500, singlePayments.currentBalance(new InternalAccount(IBAN_from)).amount);
        assertEquals(500, singlePayments.currentBalance(new InternalAccount(IBAN_to)).amount);
    }

    @Test
    void internalTransferInsufficientFunds() {
        InternalAccount from = new InternalAccount(IBAN_to);
        InternalAccount to = new InternalAccount(IBAN_from);
        assertThrows(InsufficientFundsException.class, () -> singlePayments.internalTransfer(from, to, 500));
    }

    @Test
    void externalTransferSufficientFunds() {
        InternalAccount from = new InternalAccount(IBAN_from);
        ExternalAccount to = new ExternalAccount(IBAN_to_E);
        singlePayments.externalTransfer(from, to, 500);
        assertEquals(500, singlePayments.currentBalance(new InternalAccount(IBAN_from)).amount);
        assertEquals(500, singlePayments.currentBalance(new InternalAccount(IBAN_to)).amount);
    }

    @Test
    void unknownAccount() {
        singlePayments.currentBalance(new InternalAccount("CH-no-such-acc"));
    }

    @Test
    void currentBalance() {
        assertEquals(BALANCE, singlePayments.currentBalance(new InternalAccount(IBAN_from)).amount);
    }

    class MockAccountAccess implements AccountAccess {

        Map<String, Account> accounts = new HashMap<>();
        Ledger ledger = new Ledger();

        MockAccountAccess() {
            accounts.put(IBAN_from, new SavingsAccount(IBAN_from, BALANCE));
            accounts.put(IBAN_to, new SavingsAccount(IBAN_from, 0));
        }

        @Override
        public Account retrieveAccount(InternalAccount accountDef) {
            return accounts.get(accountDef.IBAN);
        }

        @Override
        public Ledger retrieveLedger() {
            return ledger;
        }
    }
}