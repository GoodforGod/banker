package com.work.agent.services.impl;

import com.work.agent.model.Client;
import com.work.agent.services.IClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {

    @Override
    public Client register(final String name) {
        return null;
    }

    @Override
    public Client find(final Long id) {
        return null;
    }

    @Override
    public Client update(final Client client) {
        return null;
    }

    @Override
    public boolean remove(final Long id) {
        return false;
    }
}
