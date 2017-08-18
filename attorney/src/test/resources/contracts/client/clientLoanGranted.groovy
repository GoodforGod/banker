package contracts.client

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/verify'

        body([
                'balance' : $(regex('[0-9]{6,10}')),
                'amount' : $(regex('[0-9]{1,4}'))
        ])

        headers {
            contentType('application/json;charset=UTF-8')
        }
    }

    response {
        status 200

        body([
                'message' : 'Loan approved.',
                'status' : 'APPROVED'
        ])

        headers {
            contentType('application/json;charset=UTF-8')
        }
    }
}
