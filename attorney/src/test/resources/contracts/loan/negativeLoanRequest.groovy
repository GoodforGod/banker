package contracts.loan

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/verify'

        body([
                'balance' : $(regex('[1-9]{5,}')),
                'amount' : $(regex('-[1-9]+'))
        ])

        headers {
            contentType('application/json')
        }
    }

    response {
        status 200

        body([
                'message' : 'Loan is negative value.',
                'status' : 'REJECTED'
        ])

        headers {
            contentType('application/json')
        }
    }
}

