package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/verify'

        body([
               'client.id' : $(regex('[0-9]{10}')),
               loanAmount : $(regex('[0-9]{5-100}'))
        ])

        headers {
            contentType('application/json;charset=UTF-8')
        }
    }

    response {
        status 200

        body([
                'message' : 'Stop been a fraud.',
        ])

        headers {
            contentType('application/json;charset=UTF-8')
        }
    }
}
