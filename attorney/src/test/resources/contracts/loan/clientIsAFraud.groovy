package contracts.loan

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/verify'

        body([
                'balance' : '',
                'amount' : ''
        ])

        headers {
            contentType('application/json;charset=UTF-8')
        }
    }

    response {
        status 200

        body([
                'message' : 'Fraud detected.',
                'status' : 'REJECTED'
        ])

        headers {
            contentType('application/json;charset=UTF-8')
        }
    }
}
