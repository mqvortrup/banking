package qm.banking.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Ledger {

    private final List<LedgerEntry> entries = new ArrayList<>();

    public void addEntry(LedgerEntry entry) {
        entries.add(entry);
    }
}
