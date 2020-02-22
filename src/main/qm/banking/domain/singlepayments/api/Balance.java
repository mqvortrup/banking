package qm.banking.domain.singlepayments.api;

import java.time.LocalDateTime;

public final class Balance {

    public final String IBAN;

    public final LocalDateTime date;

    public final int amount;

    public Balance(String IBAN, LocalDateTime date, int amount) {
        this.IBAN = IBAN;
        this.date = date;
        this.amount = amount;
    }
}
