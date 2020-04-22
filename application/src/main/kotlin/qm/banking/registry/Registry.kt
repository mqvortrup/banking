package qm.banking.registry

import qm.banking.singlepayments.api.AccountAccess
import qm.banking.singlepayments.api.SinglePayments

class Registry private constructor() {
    var theAccountAccess: AccountAccess? = null
    var theSinglePayments: SinglePayments? = null

    companion object {
        val instance = Registry()
    }
}