package qm.banking.domain.singlepayments.api;

import qm.banking.domain.entities.Account;
import qm.banking.domain.entities.Ledger;

public interface AccountAccess {
    Account retrieveAccount(InternalAccount accountDef);

    Ledger retrieveLedger();
}
