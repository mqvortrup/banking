package qm.banking.domain.entities;

import qm.banking.domain.singlepayments.api.InternalAccount;

public class LedgerEntry {

    private final int amount;
    private final InternalAccount from, to;

    public LedgerEntry(int amount, InternalAccount from, InternalAccount to) {
        this.amount = amount;
        this.from = from;
        this.to = to;
    }

    public int getAmount() {
        return amount;
    }

    public InternalAccount getFrom() {
        return from;
    }

    public InternalAccount getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "LedgerEntry{" +
                "amount=" + amount +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
