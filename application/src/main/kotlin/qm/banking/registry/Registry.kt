package qm.banking.registry

import qm.banking.singlepayments.api.AccountAccess
import qm.banking.singlepayments.api.SinglePayments

class Registry private constructor() {
    val theAccountAccess: AccountAccess? = null
    val theSinglePayments: SinglePayments? = null

    companion object {
        val instance = Registry()
    }
}