package com.work.agent.services;

import com.work.agent.model.Client;

public interface IClientService {
    Client register(final String name);

    Client find(final Long id);

    Client update(final Client client);

    boolean remove(final Long id);
}
