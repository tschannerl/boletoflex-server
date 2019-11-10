package com.boletoflex.server.services;

import com.boletoflex.server.models.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAllClient();
    Client save(Client client) throws Exception;
}
