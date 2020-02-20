package qm.banking.domain.registry;

import qm.banking.domain.singlepayments.api.AccountAccess;
import qm.banking.domain.singlepayments.api.SinglePayments;

public class Registry {

    private AccountAccess theAccountAccess;
    private SinglePayments theSinglePayments;

    static private final Registry instance = new Registry();

    public AccountAccess getTheAccountAccess() {
        return theAccountAccess;
    }

    public void setTheAccountAccess(AccountAccess theAccountAccess) {
        this.theAccountAccess = theAccountAccess;
    }

    public static Registry getInstance() {
        return instance;
    }


    public SinglePayments getTheSinglePayments() {
        return theSinglePayments;
    }

    public void setTheSinglePayments(SinglePayments theSinglePayments) {
        this.theSinglePayments = theSinglePayments;
    }


    private Registry() {
        //do nothing
    }
}
