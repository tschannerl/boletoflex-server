package com.boletoflex.server.services;

import com.boletoflex.server.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findAllClient();
    Client save(Client client) throws Exception;
    Optional<Client> findById(Long id);
}
