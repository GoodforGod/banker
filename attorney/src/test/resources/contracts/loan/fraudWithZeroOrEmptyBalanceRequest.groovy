package contracts.loan

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/verify'

        body([
                'balance' : $(regex('[0]?')),
                'amount' : $(regex('[1-9]?[0-9]{0,4}'))
        ])

        headers {
            contentType('application/json')
        }
    }

    response {
        status 200

        body([
                'message' : 'Fraud detected.',
                'status' : 'REJECTED'
        ])

        headers {
            contentType('application/json')
        }
    }
}
