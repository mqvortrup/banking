package qm.banking.domain.registry

import qm.banking.domain.singlepayments.api.AccountAccess
import qm.banking.domain.singlepayments.api.SinglePayments

class Registry private constructor() {
    var theAccountAccess: AccountAccess? = null
    var theSinglePayments: SinglePayments? = null

    companion object {
        val instance = Registry()
    }
}