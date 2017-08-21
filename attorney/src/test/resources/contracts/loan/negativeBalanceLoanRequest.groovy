package contracts.loan

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/verify'

        body([
                'balance' : $(regex('-[0-9]{1,}')),
                'amount' : $(regex('[1-9]{1,5}'))
        ])

        headers {
            contentType('application/json')
        }
    }

    response {
        status 200

        body([
                'message' : 'Balance is negative.',
                'status' : 'REJECTED'
        ])

        headers {
            contentType('application/json')
        }
    }
}
