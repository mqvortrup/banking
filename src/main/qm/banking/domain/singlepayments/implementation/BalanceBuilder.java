package qm.banking.domain.singlepayments.implementation;

import qm.banking.domain.entities.Account;
import qm.banking.domain.singlepayments.api.Balance;

import java.time.LocalDateTime;

public class BalanceBuilder {
    public static Balance balance(Account account) {
        return new Balance(account.getIBAN(), LocalDateTime.now(), account.getBalance());
    }
}
