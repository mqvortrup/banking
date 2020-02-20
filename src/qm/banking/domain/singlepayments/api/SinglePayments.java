package qm.banking.domain.singlepayments.api;

public interface SinglePayments {

    void internalTransfer(InternalAccount from, InternalAccount to, int amount);

    void externalTransfer(InternalAccount from, ExternalAccount to, int amount);

    Balance currentBalance(InternalAccount account);

}
