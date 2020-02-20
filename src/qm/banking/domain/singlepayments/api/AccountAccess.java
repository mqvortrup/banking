package qm.banking.domain.singlepayments.api;

import qm.banking.domain.entities.Account;

public interface AccountAccess {
    Account retrieveAccount(InternalAccount accountDef);
}
