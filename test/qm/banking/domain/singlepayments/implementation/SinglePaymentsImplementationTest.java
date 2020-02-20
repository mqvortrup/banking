package qm.banking.domain.singlepayments.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qm.banking.domain.entities.Account;
import qm.banking.domain.entities.SavingsAccount;
import qm.banking.domain.singlepayments.api.AccountAccess;
import qm.banking.domain.singlepayments.api.InternalAccount;
import qm.banking.domain.singlepayments.api.SinglePayments;

import static org.junit.jupiter.api.Assertions.*;

class SinglePaymentsImplementationTest {

    public static final int BALANCE = 1000;
    public static final String IBAN = "CH-102030";

    private SinglePayments singlePayments;

    @BeforeEach
    void setup() {
        singlePayments = new SinglePaymentsImplementation(
                accountDef -> new SavingsAccount(accountDef.IBAN, BALANCE)
        );
    }

    @Test
    void internalTransfer() {
    }

    @Test
    void externalTransfer() {
    }

    @Test
    void currentBalance() {
        assertEquals(BALANCE, singlePayments.currentBalance(new InternalAccount(IBAN)).amount);
    }
}