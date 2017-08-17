package com.work.agent.controllers;

import com.work.agent.model.Account;
import com.work.agent.model.Client;
import com.work.agent.services.IClientService;
import com.work.agent.services.impl.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRestController {

    private final IClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    public Client registerClient(@RequestParam("name") final String name) {
        return clientService.register(name);
    }

    public Account refillAccount(@RequestParam("id") final Long id,
                                 @RequestParam("amount") final Long amount) {
        final Client client = clientService.find(id);
        client.getAccount().setBalance(amount);
        return clientService.update(client).getAccount();
    }

    public Boolean removeClient(@RequestParam("id") final Long id) {
        return clientService.remove(id);
    }
}
