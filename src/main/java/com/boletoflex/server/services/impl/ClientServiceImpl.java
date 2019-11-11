package com.boletoflex.server.services.impl;

import com.boletoflex.server.models.Client;
import com.boletoflex.server.repositories.ClientRepository;
import com.boletoflex.server.services.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {
    private static final Logger logger = LogManager.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAllClient() {
        logger.info(String.format("Buscando todos os Clientes"));
        return clientRepository.findAll();
    }

    @Override
    public Client save(Client client) throws Exception {
        logger.info(String.format("Salvando o Cliente [%s]", client.getName()));
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findById(Long id) {
        logger.info(String.format("Buscando Cliente por id [%d]", id));
        return clientRepository.findById(id);
    }
}
