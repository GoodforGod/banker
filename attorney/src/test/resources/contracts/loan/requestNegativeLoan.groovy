package contracts.loan

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/verify'

        body([
                'balance' : $(regex('[1-9]{6,10}')),
                'amount' : $(regex('-[0-9]+'))
        ])

        headers {
            contentType('application/json')
        }
    }

    response {
        status 200

        body([
                'message' : 'Loan is negative.',
                'status' : 'REJECTED'
        ])

        headers {
            contentType('application/json')
        }
    }
}

