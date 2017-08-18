package com.work.agent.controllers;

import com.work.agent.model.Account;
import com.work.agent.model.Client;
import com.work.agent.services.IClientService;
import com.work.agent.services.impl.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRestController {

    private final IClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/register")
    public Client registerClient(@RequestParam("name") final String name) {
        return clientService.register(name);
    }

    @PostMapping("/replenish/{id}")
    public Account replenishAccount(@PathVariable("id") final Long id,
                                    @RequestParam("amount") final Long amount) {
        final Client client = clientService.find(id);
        client.getAccount().replenish(amount);
        return clientService.update(client).getAccount();
    }

    @PostMapping("/withdraw/{id}")
    public Account withdrawMoney(@PathVariable("id") final Long id,
                                 @RequestParam("amount") final Long amount) {
        final Client client = clientService.find(id);
        client.getAccount().replenish(amount);
        return clientService.update(client).getAccount();
    }

    @PostMapping("/leave")
    public String removeClient(@RequestParam("id") final Long id) {
        return (clientService.remove(id))
                ? "SUCCESS"
                : "ERROR";
    }
}
