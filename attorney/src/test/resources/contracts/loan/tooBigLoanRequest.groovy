package contracts.loan

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/verify'

        body([
                "balance" : $(regex('[1-9][0-9]{4,}')),
                "amount" : $(regex('[1-9][0-9]{5,}'))
        ])

        headers {
            contentType('application/json')
        }
    }

    response {
        status 200

        body([
                'message' : 'Loan is too big.',
                'status' : 'REJECTED'
        ])

        headers {
            contentType('application/json')
        }
    }
}

