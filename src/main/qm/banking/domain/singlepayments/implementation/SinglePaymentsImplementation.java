package qm.banking.domain.singlepayments.implementation;

import qm.banking.domain.entities.Account;
import qm.banking.domain.entities.Ledger;
import qm.banking.domain.entities.LedgerEntry;
import qm.banking.domain.singlepayments.api.Balance;
import qm.banking.domain.singlepayments.api.ExternalAccount;
import qm.banking.domain.singlepayments.api.InternalAccount;
import qm.banking.domain.singlepayments.api.SinglePayments;
import qm.banking.domain.singlepayments.api.AccountAccess;

public class SinglePaymentsImplementation implements SinglePayments {

    private final AccountAccess accountAccess;

    public SinglePaymentsImplementation(AccountAccess accountAccess) {
        this.accountAccess = accountAccess;
    }

    @Override
    public void internalTransfer(InternalAccount fromDef, InternalAccount toDef, int amount) {
        Account from = accountAccess.retrieveAccount(fromDef);
        Account to = accountAccess.retrieveAccount(toDef);
        from.credit(amount);
        to.debit(amount);
        Ledger ledger = accountAccess.retrieveLedger();
        ledger.addEntry(new LedgerEntry(amount, fromDef, toDef));
    }

    @Override
    public void externalTransfer(InternalAccount from, ExternalAccount to, int amount) {
        throw new IllegalStateException("not implemented");
    }

    @Override
    public Balance currentBalance(InternalAccount accountDef) {
        Account account = accountAccess.retrieveAccount(accountDef);
        return BalanceBuilder.balance(account);
    }
}
