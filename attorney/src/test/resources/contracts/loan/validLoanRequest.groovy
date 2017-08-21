package contracts.loan

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/verify'

        body([
                'balance' : $(regex('[0-9]{6,}')),
                'amount' : $(regex('[0-9]{1,4}'))
        ])

        headers {
            contentType('application/json')
        }
    }

    response {
        status 200

        body([
                'message' : 'Loan approved.',
                'status' : 'APPROVED'
        ])

        headers {
            contentType('application/json')
        }
    }
}

