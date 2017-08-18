package com.work.agent.services.impl;

import com.work.agent.model.Client;
import com.work.agent.services.IClientService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientService implements IClientService {

    private Map<Long, Client> clientBase = new HashMap<>();

    @Override
    public Client register(final String name) {
        final Client client = new Client(name);
        clientBase.put(client.getId(), client);
        return client;
    }

    @Override
    public Client find(final Long id) {
        return clientBase.get(id);
    }

    @Override
    public Client update(final Client client) {
        final Client prev = clientBase.replace(client.getId(), client);
        return (prev == null)
                ? null
                : client;
    }

    @Override
    public boolean remove(final Long id) {
        return (clientBase.remove(id) != null);
    }
}
