package com.boletoflex.server.services.impl;

import com.boletoflex.server.models.User;
import com.boletoflex.server.repositories.UserRepository;
import com.boletoflex.server.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(ClientServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        logger.debug(String.format("Buscando usuário [%s]", username));
        return userRepository.findByUsername(username);
    }
}
