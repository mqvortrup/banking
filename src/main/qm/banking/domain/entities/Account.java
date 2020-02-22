package qm.banking.domain.entities;

public abstract class Account {

    private final String IBAN;
    private int balance;

    public Account(String IBAN, int balance) {
        this.IBAN = IBAN;
        this.balance = balance;
    }

    public String getIBAN() {
        return IBAN;
    }

    public int getBalance() {
        return balance;
    }

    public void credit(int amount) {
        if (amount > balance) throw new InsufficientFundsException(IBAN);
        balance -= amount;
    }

    public void debit(int amount) {
        balance += amount;
    }
}
