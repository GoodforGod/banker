package com.work.agent.services;

import com.work.agent.model.Client;
import com.work.agent.services.impl.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Test
    public void createClient() {
        Client client = clientService.register("Bob");
        assertNotNull(client);
    }

    @Test
    public void replenishClientBalance() {
        Client client = clientService.register("Bob");
        assertNotNull(client);

        client.getAccount().replenish(100);

        Client updated = clientService.update(client);
        assertNotNull(updated);
        assertEquals(100, (long)updated.getAccount().getBalance());
    }

    @Test
    public void withdrawClientBalance() {
        Client client = clientService.register("Bob");
        assertNotNull(client);

        client.getAccount().replenish(100);

        Client updated = clientService.update(client);
        assertNotNull(updated);
        assertEquals(100L, (long)updated.getAccount().getBalance());

        client.getAccount().withdraw(50);

        assertEquals(50L, (long)client.getAccount().getBalance());
    }

    @Test
    public void updateNotExistedClient() {
        Client updated = clientService.update(new Client("Tim"));
        assertNull(updated);
    }

    @Test
    public void findClient() {
        Client client = clientService.register("Bob");
        assertNotNull(client);

        Client found = clientService.find(client.getId());
        assertNotNull(found);
    }

    @Test
    public void findNotExistedClient() {
        Client client = clientService.find(new Client("Tim").getId());
        assertNull(client);
    }

    @Test
    public void removeClient() {
        Client client = clientService.register("Bob");
        assertNotNull(client);

        boolean removed = clientService.remove(client.getId());
        assertTrue(removed);
    }

    @Test
    public void removeNotExistedClient() {
        boolean removed = clientService.remove(new Client("Tim").getId());
        assertFalse(removed);
    }
}
