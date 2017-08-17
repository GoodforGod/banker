package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/verify'

        body([
                'client.id' : $(regex('[0-9]{10}')),
                loanAmount : $(regex('[0-9]{1-4}'))
        ])

        headers {
            contentType('application/json;charset=UTF-8')
        }
    }

    response {
        status 200

        body([
                'message' : 'Loan granted.',
        ])

        headers {
            contentType('application/json;charset=UTF-8')
        }
    }
}

