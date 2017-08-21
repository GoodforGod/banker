package contracts.loan

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/verify'

        body([
                'balance' : $(regex('[1-9][0-9]{4,}')),
                'amount' : $(regex('[0]?'))
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
