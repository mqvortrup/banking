package qm.banking.domain.entities;

public class InsufficientFundsException extends RuntimeException {
    private final String IBAN;

    public InsufficientFundsException(String IBAN) {
        super("Insufficient funds in " + IBAN);
        this.IBAN = IBAN;
    }

    public String getIBAN() {
        return IBAN;
    }

}
