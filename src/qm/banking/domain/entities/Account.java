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
    }}
